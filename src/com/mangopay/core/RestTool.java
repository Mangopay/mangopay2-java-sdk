package com.mangopay.core;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mangopay.MangoPayApi;
import com.mangopay.entities.BankAccount;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.PayOut;
import com.mangopay.entities.User;
import com.mangopay.entities.UserLegal;
import com.mangopay.entities.UserNatural;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.regex.Matcher;

/**
 * Class used to build HTTP request, call the request and handle response.
 */
public class RestTool {
    
    // root/parent instance that holds the OAuthToken and Configuration instance
    private MangoPayApi _root;
    
    // enable/disable debugging
    private Boolean _debugMode;
    
    // variable to flag that in request authentication data are required
    private Boolean _authRequired;
    
    // array with HTTP header to send with request
    private Map<String, String> _requestHttpHeaders;
    
    // HTTP communication object
    private HttpURLConnection _connection;
    
    // request type for current request
    private String _requestType;
    
    // key-value collection pass in the request
    private Map<String, String> _requestData;
    
    // code get from response
    private int _responseCode;
    
    // pagination object
    private Pagination _pagination;
    
    // slf4j logger facade
    private Logger _logger;
        
    /**
     * Instantiates new RestTool object.
     * @param root          Root/parent instance that holds the OAuthToken and Configuration instance.
     * @param authRequired  Defines whether request authentication is required.
     * @throws Exception
     */
    public RestTool(MangoPayApi root, Boolean authRequired) throws Exception {
        this._root = root;
        this._authRequired = authRequired;
        this._debugMode = this._root.Config.DebugMode;
        
        _logger = LoggerFactory.getLogger(RestTool.class);
    }
    
    /**
     * Adds HTTP headers as name/value pairs into the request.
     * @param httpHeader    Collection of headers name/value pairs.
     */
    public void addRequestHttpHeader(Map<String, String> httpHeader) {
        
        if (this._requestHttpHeaders == null)
            this._requestHttpHeaders = new HashMap<>();
        
        this._requestHttpHeaders.putAll(httpHeader);
    }    
    
    /**
     * Adds HTTP header into the request.
     * @param key       Header name.
     * @param value     Header value.
     */
    public void addRequestHttpHeader(final String key, final String value) {
        addRequestHttpHeader(new HashMap<String, String>(){{
            put(key, value);
        }});
    }
    
    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting single 
     * <code>Dto</code> instances. In order to process collections of objects, 
     * use <code>requestList</code> method instead.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param urlMethod     Relevant method key.
     * @param requestType   HTTP request term, one of the GET, PUT or POST.
     * @param requestData   Collection of key-value pairs of request 
                            parameters.
     * @param pagination    Pagination object.
     * @param entity        Instance of Dto class that is going to be
                            sent in case of PUTting or POSTing.
     * @return              The Dto instance returned from API.
     * @throws Exception
     */
    public <T extends Dto> T request(Class<T> classOfT, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination, T entity) throws Exception {
        
        this._requestType = requestType;
        this._requestData = requestData;
        
        T responseResult = this.doRequest(classOfT, urlMethod, pagination, entity);
        
        if(pagination != null){
            pagination = this._pagination;
        }
        
        return responseResult;
    }
    
    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting single 
     * <code>Dto</code> instances. In order to process collections of objects, 
     * use <code>requestList</code> method instead.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param urlMethod     Relevant method key.
     * @param requestType   HTTP request term, one of the GET, PUT or POST.     
     * @return              The Dto instance returned from API.
     * @throws Exception
     */
    public <T extends Dto> T request(Class<T> classOfT, String urlMethod, String requestType) throws Exception {
        return request(classOfT, urlMethod, requestType, null, null, null);
    }
    
    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting single 
     * <code>Dto</code> instances. In order to process collections of objects, 
     * use <code>requestList</code> method instead.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param urlMethod     Relevant method key.
     * @param requestType   HTTP request term, one of the GET, PUT or POST.
     * @param requestData   Collection of key-value pairs of request 
                            parameters.
     * @return              The Dto instance returned from API.
     * @throws Exception
     */
    public <T extends Dto> T request(Class<T> classOfT, String urlMethod, String requestType, Map<String, String> requestData) throws Exception {
        return request(classOfT, urlMethod, requestType, requestData, null, null);
    }
    
    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting single 
     * <code>Dto</code> instances. In order to process collections of objects, 
     * use <code>requestList</code> method instead.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param urlMethod     Relevant method key.
     * @param requestType   HTTP request term, one of the GET, PUT or POST.
     * @param requestData   Collection of key-value pairs of request 
                            parameters.
     * @param pagination    Pagination object.
     * @return              The Dto instance returned from API.
     * @throws Exception
     */
    public <T extends Dto> T request(Class<T> classOfT, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination) throws Exception {
        return request(classOfT, urlMethod, requestType, requestData, pagination, null);
    }
    
    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting collections of 
     * <code>Dto</code> instances. In order to process single objects, 
     * use <code>request</code> method instead.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param classOfTItem  The class of single item in array.
     * @param urlMethod     Relevant method key.
     * @param requestType   HTTP request term. For lists should be always GET.
     * @param requestData   Collection of key-value pairs of request 
                            parameters.
     * @param pagination    Pagination object.
     * @param additionalUrlParams
     * @return              The collection of Dto instances returned from API.
     * @throws Exception
     */
    public <T extends Dto> List<T> requestList(Class<T[]> classOfT, Class<T> classOfTItem, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination, Map<String, String> additionalUrlParams) throws Exception {
        
        this._requestType = requestType;
        this._requestData = requestData;
        
        List<T> responseResult = this.doRequestList(classOfT, classOfTItem, urlMethod, pagination, additionalUrlParams);
        
        if(pagination != null){
            pagination = this._pagination;
        }
        
        return responseResult;
    }
    
    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting collections of 
     * <code>Dto</code> instances. In order to process single objects, 
     * use <code>request</code> method instead.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param classOfTItem  The class of single item in array.
     * @param urlMethod     Relevant method key.
     * @param requestType   HTTP request term. For lists should be always GET.
     * @return              The collection of Dto instances returned from API.
     * @throws Exception
     */
    public <T extends Dto> List<T> requestList(Class<T[]> classOfT, Class<T> classOfTItem, String urlMethod, String requestType) throws Exception {
        return requestList(classOfT, classOfTItem, urlMethod, requestType, null, null, null);
    }
    
    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting collections of 
     * <code>Dto</code> instances. In order to process single objects, 
     * use <code>request</code> method instead.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param classOfTItem  The class of single item in array.
     * @param urlMethod     Relevant method key.
     * @param requestType   HTTP request term. For lists should be always GET.
     * @param requestData   Collection of key-value pairs of request 
                            parameters.
     * @return              The collection of Dto instances returned from API.
     * @throws Exception
     */
    public <T extends Dto> List<T> requestList(Class<T[]> classOfT, Class<T> classOfTItem, String urlMethod, String requestType, Map<String, String> requestData) throws Exception {
        return requestList(classOfT, classOfTItem, urlMethod, requestType, requestData, null, null);
    }
    
    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting collections of 
     * <code>Dto</code> instances. In order to process single objects, 
     * use <code>request</code> method instead.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param classOfTItem  The class of single item in array.
     * @param urlMethod     Relevant method key.
     * @param requestType   HTTP request term. For lists should be always GET.
     * @param requestData   Collection of key-value pairs of request 
                            parameters.
     * @param pagination    Pagination object.     
     * @return              The collection of Dto instances returned from API.
     * @throws Exception
     */
    public <T extends Dto> List<T> requestList(Class<T[]> classOfT, Class<T> classOfTItem, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination) throws Exception {
        return requestList(classOfT, classOfTItem, urlMethod, requestType, requestData, pagination, null);
    }
    
    private <T extends Dto> T doRequest(Class<T> classOfT, String urlMethod, Pagination pagination, T entity) throws Exception {
        
        T response = null;
        
        try {
            UrlTool urlTool = new UrlTool(_root);
            String restUrl = urlTool.getRestUrl(urlMethod, this._authRequired, pagination, null);
            
            URL url = new URL(urlTool.getFullUrl(restUrl));

            
            
            if (this._debugMode) {
                _logger.info("FullUrl: {}", urlTool.getFullUrl(restUrl));
            }

            /*  FOR WEB DEBUG PURPOSES
            SocketAddress addr = new InetSocketAddress("localhost", 8888);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
            _connection = (HttpURLConnection)url.openConnection(proxy);
            */
            
            _connection = (HttpURLConnection)url.openConnection();
            _connection.setConnectTimeout(60000);
            _connection.setReadTimeout(60000);
            
            // set request method
            _connection.setRequestMethod(this._requestType);
            
            // set headers
            Map<String, String> httpHeaders = this.getHttpHeaders(restUrl);
            
            for (Entry<String, String> entry : httpHeaders.entrySet()) {
                _connection.addRequestProperty(entry.getKey(), entry.getValue());
                
                if (this._debugMode)
                    _logger.info("HTTP Header: {}", entry.getKey() + ": " + entry.getValue());
            }
            
            // prepare to go
            _connection.setUseCaches (false);
            _connection.setDoInput(true);
            _connection.setDoOutput(true);

            if (pagination != null) {
                this._pagination = pagination;
            }

            if (this._debugMode)
                _logger.info("RequestType: {}", this._requestType);

            if (this._requestData != null || entity != null) {

                String requestBody = "";
                if (entity != null) {
                    HashMap<String, Object> requestData = buildRequestData(classOfT, entity);
                    
                    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                    requestBody = gson.toJson(requestData);
                }
                if (this._requestData != null) {
                    String params = "";
                    for (Entry<String, String> entry : this._requestData.entrySet()) {
                        params += String.format("&%s=%s", URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
                    }
                    requestBody = params.replaceFirst("&", "");
                }
                 
                if (this._debugMode) {
                    _logger.info("RequestData: {}", this._requestData);
                    _logger.info("RequestBody: {}", requestBody);
                }
                
                try (OutputStreamWriter osw = new OutputStreamWriter(_connection.getOutputStream(), "UTF-8")) {
                    osw.write(requestBody);
                    osw.flush();
                }
            }
            

            // get response
            this._responseCode = _connection.getResponseCode();
            InputStream is;
            if (this._responseCode != 200 && this._responseCode != 204) {
                is = _connection.getErrorStream();
            } else {
                is = _connection.getInputStream();
            }
            
            StringBuffer resp;
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
                String line;
                resp = new StringBuffer();
                while((line = rd.readLine()) != null) {
                    resp.append(line);
                }
            }
            String responseString = resp.toString();
            
            if (this._debugMode) {
                if (this._responseCode == 200 || this._responseCode == 204) {
                    _logger.info("Response OK: {}", responseString);
                } else {
                    _logger.info("Response ERROR: {}", responseString);
                }
            }
        
            if (this._responseCode == 200) {
                
                this.readResponseHeaders(_connection);
                
                response = castResponseToEntity(classOfT, new JsonParser().parse(responseString).getAsJsonObject());

                if (this._debugMode) _logger.info("Response object: {}", response.toString());
            }
            
            this.checkResponseCode(responseString);
            
        }
        catch (Exception ex) {
            //ex.printStackTrace();
            if (this._debugMode) _logger.error("EXCEPTION: {}", Arrays.toString(ex.getStackTrace()));
            throw ex;
        }
        
        return response;
    }
    
    private void readResponseHeaders(HttpURLConnection conn) {
        for (Map.Entry<String, List<String>> k : conn.getHeaderFields().entrySet()) {
            for (String v : k.getValue()){
                
                if (this._debugMode) _logger.info("Response header: {}", k.getKey() + ":" + v);

                if (k.getKey() == null) continue;
                
                if (k.getKey().equals("X-Number-Of-Pages")) {
                    this._pagination.TotalPages = Integer.parseInt(v);
                }
                if (k.getKey().equals("X-Number-Of-Items")) {
                    this._pagination.TotalItems = Integer.parseInt(v);
                }
                if (k.getKey().equals("Link")) {
                    String linkValue = v;
                    String[] links = linkValue.split(",");

                    if (links != null && links.length > 0) {
                        for (String link : links) {
                            link = link.replaceAll(Matcher.quoteReplacement("<\""), "");
                            link = link.replaceAll(Matcher.quoteReplacement("\">"), "");
                            link = link.replaceAll(Matcher.quoteReplacement(" rel=\""), "");
                            link = link.replaceAll(Matcher.quoteReplacement("\""), "");

                            String[] oneLink = link.split(";");

                            if (oneLink != null && oneLink.length > 1) {
                                if (oneLink[0] != null && oneLink[1] != null) {
                                    this._pagination.Links = oneLink;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private <T extends Dto> HashMap<String, Object> buildRequestData(Class<T> classOfT, T entity) {
        HashMap<String, Object> result = new HashMap<>();
        
        ArrayList<String> readOnlyProperties = entity.getReadOnlyProperties();
        
        String fieldName = "";
        for (Field f : entity.getClass().getFields()) {
            
            boolean isList = false;
            for (Class<?> i : f.getType().getInterfaces()) {
                if (i.getName().equals("java.util.List")) {
                    isList = true;
                    break;
                }
            }
            
            fieldName = f.getName();
            
            boolean isReadOnly = false;
            for (String s : readOnlyProperties) {
                if (s.equals(fieldName)) {
                    isReadOnly = true;
                    break;
                }
            }
            if (isReadOnly) continue;
            
            
            if (canReadSubRequestData(classOfT, fieldName)) {
                HashMap<String, Object> subRequestData = new HashMap<>();
                
                try {
                    Method m = RestTool.class.getDeclaredMethod("buildRequestData", Class.class, Dto.class);
                    subRequestData = (HashMap<String, Object>)m.invoke(this, f.getType(), f.get(entity));
                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    if (this._debugMode) _logger.error("EXCEPTION: {}", Arrays.toString(ex.getStackTrace()));
                }
                    
                for (Entry<String, Object> e : subRequestData.entrySet()) {
                    result.put(e.getKey(), e.getValue());
                }
            } else {
                try {
                    if (!isList) {
                        result.put(fieldName, f.get(entity));
                    }
                    else {
                        result.put(fieldName, ((List)f.get(entity)).toArray());
                    }
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    continue;
                }
            }
            
        }
        
        return result;
    }
    
    private <T> Boolean canReadSubRequestData(Class<T> classOfT, String fieldName) {
        
        if (classOfT.getName().equals(PayIn.class.getName()) && 
                    (fieldName.equals("PaymentDetails") || fieldName.equals("ExecutionDetails"))) {
            return true;
        }
        
        if (classOfT.getName().equals(PayOut.class.getName()) && fieldName.equals("MeanOfPaymentDetails")) {
            return true;
        }
        
        if (classOfT.getName().equals(BankAccount.class.getName()) && fieldName.equals("Details")) {
            return true;
        }
        
        return false;
        
    }
    
    private <T> T castResponseToEntity(Class<T> classOfT, JsonObject response) throws Exception {
        return castResponseToEntity(classOfT, response, false);
    }
    
    private <T> T castResponseToEntity(Class<T> classOfT, JsonObject response, boolean asDependentObject) throws Exception {
        
        try {
            
            if (_debugMode) {
                _logger.info("Entity type: {}", classOfT.getName());
            }
            
            T result = null;
            
            if (classOfT.getName().equals(User.class.getName())) {
                for (Entry<String, JsonElement> entry : response.entrySet()) {
                    
                    if (entry.getKey().equals("PersonType")) {
                        switch (entry.getValue().getAsString()) {
                            case User.Types.Natural:
                                result = (T) new UserNatural();
                                break;
                            case User.Types.Legal:
                                result = (T) new UserLegal();
                                break;
                            default:
                                throw new Exception(String.format("Unknown type of user: %s", entry.getValue().getAsString()));
                        }
                    }
                    
                }
            } else {
                result = classOfT.newInstance();
            }
            
            Map<String, Type> subObjects = ((Dto)result).getSubObjects();
            Map<String, Map<String, Map<String, Class<?>>>> dependentObjects = ((Dto)result).getDependentObjects();
            
            for (Field f : result.getClass().getFields()) {
                String name = f.getName();
                
                boolean isList = false;
                for (Class<?> i : f.getType().getInterfaces()) {
                    if (i.getName().equals("java.util.List")) {
                        isList = true;
                        break;
                    }
                }
                
                // does this field have dependent objects?
                if (!asDependentObject && dependentObjects.containsKey(name)) {
                    Map<String, Map<String, Class<?>>> allowedTypes = dependentObjects.get(name);
                    
                    for (Entry<String, JsonElement> entry : response.entrySet()) {
                        if (entry.getKey().equals(name)) {
                            String paymentTypeDef = entry.getValue().getAsString();
                            
                            if (allowedTypes.containsKey(paymentTypeDef)) {
                                Map<String, Class<?>> targetObjectsDef = allowedTypes.get(paymentTypeDef);
                                
                                for (Entry<String, Class<?>> e : targetObjectsDef.entrySet()) {
                                    
                                    Field targetField = classOfT.getDeclaredField(e.getKey());
                                    
                                    if (isList) {
                                        targetField.set(result, Arrays.asList(castResponseToEntity(e.getValue(), response, true)));
                                    } else {
                                        targetField.set(result, castResponseToEntity(e.getValue(), response, true));
                                    }
                                }
                            }
                            
                            break;
                        }
                    }
                }   
                        
                for (Entry<String, JsonElement> entry : response.entrySet()) {
                    
                    if (entry.getKey().equals(name)) {
                        
                        // is sub object?
                        if (subObjects.containsKey(name)) {
                            if (entry.getValue() instanceof JsonNull) {
                                f.set(result, null);
                            }
                            else {
                                f.set(result, castResponseToEntity(f.getType(), entry.getValue().getAsJsonObject()));
                            }
                            break;
                        }
                        
                        String fieldTypeName = f.getType().getName();
                        boolean fieldIsArray = false;
                        for (Class<?> i : f.getType().getInterfaces()) {
                            if (i.getName().equals("java.util.List")) {
                                fieldIsArray = true;
                                break;
                            }
                        }
                        
                        if (_debugMode) {
                            _logger.info("Recognized field: {}", String.format("[%s] %s%s", name, fieldTypeName, fieldIsArray ? "[]" : ""));
                        }
                        
                        if (fieldIsArray) {
                            ParameterizedType genericType = (ParameterizedType) f.getGenericType();
                            Class<?> genericTypeClass = (Class<?>) genericType.getActualTypeArguments()[0];
                            
                            if (entry.getValue().isJsonArray()) {
                                JsonArray ja = entry.getValue().getAsJsonArray();
                                Iterator<JsonElement> i = ja.iterator();
                                Class<?> classOfList = Class.forName(fieldTypeName);
                                Method addMethod = classOfList.getDeclaredMethod("add", Object.class);
                                Method toArrayMethod = classOfList.getDeclaredMethod("add", Object.class);
                                Object o = classOfList.newInstance();
                                while (i.hasNext()) {
                                    JsonElement e = i.next();
                                    
                                    if (genericTypeClass.getName().equals(String.class.getName())) {
                                        addMethod.invoke(o, e.getAsJsonPrimitive().getAsString());
                                    } else if (genericTypeClass.getName().equals(int.class.getName())) {
                                        addMethod.invoke(o, e.getAsJsonPrimitive().getAsInt());
                                    } else if (genericTypeClass.getName().equals(long.class.getName())) {
                                        addMethod.invoke(o, e.getAsJsonPrimitive().getAsLong());
                                    } else if (genericTypeClass.getName().equals(Double.class.getName())) {
                                        addMethod.invoke(o, e.getAsJsonPrimitive().getAsDouble());
                                    }
                                }
                                f.set(result, o);
                            }
                        } else {
                            if (!entry.getValue().isJsonNull()) {
                                if (fieldTypeName.equals(int.class.getName())) {
                                    f.setInt(result, entry.getValue().getAsInt());
                                } else if (fieldTypeName.equals(long.class.getName())) {
                                    f.setLong(result, entry.getValue().getAsLong());
                                } else if (fieldTypeName.equals(Double.class.getName())) {
                                    f.set(result, entry.getValue().getAsDouble());
                                } else if (fieldTypeName.equals(String.class.getName())) {
                                    f.set(result, entry.getValue().getAsString());
                                }
                            }
                            
                            break;
                        }
                    }
                    
                }
                
            }
            
            return result;
            
        } catch (Exception e) {
            if (this._debugMode) _logger.error("EXCEPTION: {}", Arrays.toString(e.getStackTrace()));
            
            throw e;
        }
        
    }
    
    private <T extends Dto> List<T> doRequestList(Class<T[]> classOfT, Class<T> classOfTItem, String urlMethod, Pagination pagination) throws Exception {
        return doRequestList(classOfT, classOfTItem, urlMethod, pagination, null);
    }
    
    private <T extends Dto> List<T> doRequestList(Class<T[]> classOfT, Class<T> classOfTItem, String urlMethod, Pagination pagination, Map<String, String> additionalUrlParams) throws Exception {
        
        List<T> response = new ArrayList<>();
        
        try {
            UrlTool urlTool = new UrlTool(_root);
            String restUrl = urlTool.getRestUrl(urlMethod, this._authRequired, pagination, additionalUrlParams);
            
            URL url = new URL(urlTool.getFullUrl(restUrl));

            if (this._debugMode)
                _logger.info("FullUrl: {}", urlTool.getFullUrl(restUrl));

            _connection = (HttpURLConnection)url.openConnection();
            
            // set request method
            _connection.setRequestMethod(this._requestType);
            
            // set headers
            Map<String, String> httpHeaders = this.getHttpHeaders(restUrl);
            
            for (Entry<String, String> entry : httpHeaders.entrySet()) {
                _connection.addRequestProperty(entry.getKey(), entry.getValue());
                
                if (this._debugMode)
                    _logger.info("HTTP Header: {}", entry.getKey() + ": " + entry.getValue());
            }
            
            // prepare to go
            _connection.setUseCaches (false);
            _connection.setDoInput(true);
            _connection.setDoOutput(true);

            if (pagination != null) {
                this._pagination = pagination;
            }

            if (this._debugMode)
                _logger.info("RequestType: {}", this._requestType);

            if (this._requestData != null) {

                String requestBody;
                String params = "";
                for (Entry<String, String> entry : this._requestData.entrySet()) {
                    params += String.format("&%s=%s", URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
                requestBody = params.replaceFirst("&", "");
                
                try (DataOutputStream wr = new DataOutputStream (_connection.getOutputStream())) {
                    wr.writeBytes(requestBody);
                    wr.flush();
                }

                if (this._debugMode) {
                    _logger.info("RequestData: {}", this._requestData);
                    _logger.info("RequestBody: {}", requestBody);
                }
            }
            

            //Get Response	
            this._responseCode = _connection.getResponseCode();
            InputStream is;
            if (this._responseCode != 200) {
                is = _connection.getErrorStream();
            } else {
                is = _connection.getInputStream();
            }
            
            StringBuffer resp;
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
                String line;
                resp = new StringBuffer();
                while((line = rd.readLine()) != null) {
                    resp.append(line);
                    resp.append('\r');
                }
            }
            String responseString = resp.toString();
            
            if (this._debugMode) {
                if (this._responseCode == 200) {
                    _logger.info("Response OK: {}", responseString);
                } else {
                    _logger.info("Response ERROR: {}", responseString);
                }
            }
        
            if (this._responseCode == 200) {
                
                this.readResponseHeaders(_connection);
            
                JsonArray ja = new JsonParser().parse(responseString).getAsJsonArray();

                for (int x = 0; x < ja.size(); x++) {
                    JsonObject jo = ja.get(x).getAsJsonObject();
                    T toAdd = castResponseToEntity(classOfTItem, jo);
                    response.add(toAdd);
                }            

                if (this._debugMode) {
                    _logger.info("Response object: {}", response.toString());
                    _logger.info("Elements count: {}", response.size());
                }
            }

            this.checkResponseCode(responseString);
            
        }
        catch (Exception ex) {
            if (this._debugMode) _logger.error("EXCEPTION: {}", Arrays.toString(ex.getStackTrace()));
            throw ex;
        }
        
        return response;
        
    }
    
    /**
     * Gets HTTP header to use in request.
     * @param restUrl   The REST API URL.
     * @return          Array containing HTTP headers.
     */
    private Map<String, String> getHttpHeaders(String restUrl) throws Exception {
        // return if already created...
        if (this._requestHttpHeaders != null)
                return this._requestHttpHeaders;
        
        // ...or initialize with default headers
        Map<String, String> httpHeaders = new HashMap<>();
        
        // content type
        httpHeaders.put("Content-Type", "application/json");
        
        // AuthenticationHelper http header
        if (this._authRequired) {
            AuthenticationHelper authHlp = new AuthenticationHelper(_root);
            httpHeaders.putAll(authHlp.getHttpHeaderKey());
        }

        return httpHeaders;
    }
    
    /**
     * Checks the HTTP response code and if it's neither 200 nor 204 throws a ResponseException.
     * @param message   Text response.
     * @throws ResponseException If response code is other than 200 or 204.
     */
    private void checkResponseCode(String message) throws ResponseException {

        if (this._responseCode != 200 && this._responseCode != 204) {
            
            HashMap<Integer, String> responseCodes = new HashMap<Integer, String>() {{
                put(206, "PartialContent");
                put(400, "Bad request");
                put(401, "Unauthorized");
                put(403, "Prohibition to use the method");
                put(404, "Not found");
                put(405, "Method not allowed");
                put(413, "Request entity too large");
                put(422, "Unprocessable entity");
                put(500, "Internal server error");
                put(501, "Not implemented");
            }};
            
            String errorMsg = "";
            if (responseCodes.containsKey(this._responseCode)) {
                errorMsg = responseCodes.get(this._responseCode);
            } else {
                errorMsg = "Unknown response error";
            }

            if (message != null) {
                errorMsg += ". " + message;
            }
            
            throw new ResponseException(errorMsg);
        }
    }
}
