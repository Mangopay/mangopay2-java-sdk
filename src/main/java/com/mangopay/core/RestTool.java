package com.mangopay.core;

import com.google.gson.*;
import com.mangopay.MangoPayApi;
import com.mangopay.core.enumerations.PersonType;
import com.mangopay.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;

/**
 * Class used to build HTTP request, call the request and handle response.
 */
public class RestTool {

    // root/parent instance that holds the OAuthToken and Configuration instance
    private MangoPayApi root;

    // enable/disable debugging
    private Boolean debugMode;

    // variable to flag that in request authentication data are required
    private Boolean authRequired;

    // array with HTTP header to send with request
    private Map<String, String> requestHttpHeaders;

    // HTTP communication object
    private HttpURLConnection connection;

    // request type for current request
    private String requestType;

    // key-value collection pass in the request
    private Map<String, String> requestData;

    // code get from response
    private int responseCode;

    // pagination object
    private Pagination pagination;

    // slf4j logger facade
    private Logger logger;

    /**
     * Instantiates new RestTool object.
     *
     * @param root         Root/parent instance that holds the OAuthToken and Configuration instance.
     * @param authRequired Defines whether request authentication is required.
     * @throws Exception
     */
    public RestTool(MangoPayApi root, Boolean authRequired) throws Exception {
        this.root = root;
        this.authRequired = authRequired;
        this.debugMode = this.root.getConfig().isDebugMode();

        logger = LoggerFactory.getLogger(RestTool.class);
    }

    /**
     * Adds HTTP headers as name/value pairs into the request.
     *
     * @param httpHeader Collection of headers name/value pairs.
     */
    public void addRequestHttpHeader(Map<String, String> httpHeader) {

        if (this.requestHttpHeaders == null)
            this.requestHttpHeaders = new HashMap<>();

        this.requestHttpHeaders.putAll(httpHeader);
    }

    /**
     * Adds HTTP header into the request.
     *
     * @param key   Header name.
     * @param value Header value.
     */
    public void addRequestHttpHeader(final String key, final String value) {
        addRequestHttpHeader(new HashMap<String, String>() {{
            put(key, value);
        }});
    }

    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting single
     * <code>Dto</code> instances. In order to process collections of objects,
     * use <code>requestList</code> method instead.
     *
     * @param <T>         Type on behalf of which the request is being called.
     * @param classOfT    Type on behalf of which the request is being called.
     * @param urlMethod   Relevant method key.
     * @param requestType HTTP request term, one of the GET, PUT or POST.
     * @param requestData Collection of key-value pairs of request
     *                    parameters.
     * @param pagination  Pagination object.
     * @param entity      Instance of Dto class that is going to be
     *                    sent in case of PUTting or POSTing.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    public <T extends Dto> T request(Class<T> classOfT, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination, T entity) throws Exception {
        return this.request(classOfT, null, urlMethod, requestType, requestData, pagination, entity);
    }

    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting single
     * <code>Dto</code> instances. In order to process collections of objects,
     * use <code>requestList</code> method instead.
     *
     * @param <T>            Type on behalf of which the request is being called.
     * @param classOfT       Type on behalf of which the request is being called.
     * @param idempotencyKey idempotency key for this request.
     * @param urlMethod      Relevant method key.
     * @param requestType    HTTP request term, one of the GET, PUT or POST.
     * @param requestData    Collection of key-value pairs of request
     *                       parameters.
     * @param pagination     Pagination object.
     * @param entity         Instance of Dto class that is going to be
     *                       sent in case of PUTting or POSTing.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    public <T extends Dto> T request(Class<T> classOfT, String idempotencyKey, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination, T entity) throws Exception {

        this.requestType = requestType;
        this.requestData = requestData;

        T responseResult = this.doRequest(classOfT, idempotencyKey, urlMethod, pagination, entity);

        if (pagination != null) {
            pagination = this.pagination;
        }

        return responseResult;
    }

    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting single
     * <code>Dto</code> instances. In order to process collections of objects,
     * use <code>requestList</code> method instead.
     *
     * @param <T>         Type on behalf of which the request is being called.
     * @param classOfT    Type on behalf of which the request is being called.
     * @param urlMethod   Relevant method key.
     * @param requestType HTTP request term, one of the GET, PUT or POST.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    public <T extends Dto> T request(Class<T> classOfT, String idempotencyKey, String urlMethod, String requestType) throws Exception {
        return request(classOfT, idempotencyKey, urlMethod, requestType, null, null, null);
    }

    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting single
     * <code>Dto</code> instances. In order to process collections of objects,
     * use <code>requestList</code> method instead.
     *
     * @param <T>         Type on behalf of which the request is being called.
     * @param classOfT    Type on behalf of which the request is being called.
     * @param urlMethod   Relevant method key.
     * @param requestType HTTP request term, one of the GET, PUT or POST.
     * @param requestData Collection of key-value pairs of request
     *                    parameters.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    public <T extends Dto> T request(Class<T> classOfT, String idempotencyKey, String urlMethod, String requestType, Map<String, String> requestData) throws Exception {
        return request(classOfT, idempotencyKey, urlMethod, requestType, requestData, null, null);
    }

    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting single
     * <code>Dto</code> instances. In order to process collections of objects,
     * use <code>requestList</code> method instead.
     *
     * @param <T>         Type on behalf of which the request is being called.
     * @param classOfT    Type on behalf of which the request is being called.
     * @param urlMethod   Relevant method key.
     * @param requestType HTTP request term, one of the GET, PUT or POST.
     * @param requestData Collection of key-value pairs of request
     *                    parameters.
     * @param pagination  Pagination object.
     * @return The Dto instance returned from API.
     * @throws Exception
     */
    public <T extends Dto> T request(Class<T> classOfT, String idempotencyKey, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination) throws Exception {
        return request(classOfT, idempotencyKey, urlMethod, requestType, requestData, pagination, null);
    }

    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting collections of
     * <code>Dto</code> instances. In order to process single objects,
     * use <code>request</code> method instead.
     *
     * @param <T>                 Type on behalf of which the request is being called.
     * @param classOfT            Type on behalf of which the request is being called.
     * @param classOfTItem        The class of single item in array.
     * @param urlMethod           Relevant method key.
     * @param requestType         HTTP request term. For lists should be always GET.
     * @param requestData         Collection of key-value pairs of request
     *                            parameters.
     * @param pagination          Pagination object.
     * @param additionalUrlParams
     * @return The collection of Dto instances returned from API.
     * @throws Exception
     */
    public <T extends Dto> List<T> requestList(Class<T[]> classOfT, Class<T> classOfTItem, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination, Map<String, String> additionalUrlParams) throws Exception {

        this.requestType = requestType;
        this.requestData = requestData;

        List<T> responseResult = this.doRequestList(classOfT, classOfTItem, urlMethod, pagination, additionalUrlParams);

        if (pagination != null) {
            pagination = this.pagination;
        }

        return responseResult;
    }

    /**
     * Makes a call to the MangoPay API.
     * <p>
     * This generic method handles calls targeting collections of
     * <code>Dto</code> instances. In order to process single objects,
     * use <code>request</code> method instead.
     *
     * @param <T>          Type on behalf of which the request is being called.
     * @param classOfT     Type on behalf of which the request is being called.
     * @param classOfTItem The class of single item in array.
     * @param urlMethod    Relevant method key.
     * @param requestType  HTTP request term. For lists should be always GET.
     * @return The collection of Dto instances returned from API.
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
     *
     * @param <T>          Type on behalf of which the request is being called.
     * @param classOfT     Type on behalf of which the request is being called.
     * @param classOfTItem The class of single item in array.
     * @param urlMethod    Relevant method key.
     * @param requestType  HTTP request term. For lists should be always GET.
     * @param requestData  Collection of key-value pairs of request
     *                     parameters.
     * @return The collection of Dto instances returned from API.
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
     *
     * @param <T>          Type on behalf of which the request is being called.
     * @param classOfT     Type on behalf of which the request is being called.
     * @param classOfTItem The class of single item in array.
     * @param urlMethod    Relevant method key.
     * @param requestType  HTTP request term. For lists should be always GET.
     * @param requestData  Collection of key-value pairs of request
     *                     parameters.
     * @param pagination   Pagination object.
     * @return The collection of Dto instances returned from API.
     * @throws Exception
     */
    public <T extends Dto> List<T> requestList(Class<T[]> classOfT, Class<T> classOfTItem, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination) throws Exception {
        return requestList(classOfT, classOfTItem, urlMethod, requestType, requestData, pagination, null);
    }

    private <T extends Dto> T doRequest(Class<T> classOfT, String idempotencyKey, String urlMethod, Pagination pagination, T entity) throws Exception {

        T response = null;

        try {
            UrlTool urlTool = new UrlTool(root);
            String restUrl = urlTool.getRestUrl(urlMethod, this.authRequired, pagination, null);

            URL url = new URL(urlTool.getFullUrl(restUrl));


            if (this.debugMode) {
                logger.info("FullUrl: {}", urlTool.getFullUrl(restUrl));
            }

            /*  FOR WEB DEBUG PURPOSES
            SocketAddress addr = new InetSocketAddress("localhost", 8888);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
            connection = (HttpURLConnection)url.openConnection(proxy);
            */

            connection = (HttpURLConnection) url.openConnection();
            // Get connection timeout from config
            connection.setConnectTimeout(this.root.getConfig().getConnectTimeout());
            // Get read timeout from config
            connection.setReadTimeout(this.root.getConfig().getReadTimeout());

            // set request method
            connection.setRequestMethod(this.requestType);

            // set headers
            Map<String, String> httpHeaders = this.getHttpHeaders(restUrl);

            for (Entry<String, String> entry : httpHeaders.entrySet()) {
                connection.addRequestProperty(entry.getKey(), entry.getValue());

                if (this.debugMode)
                    logger.info("HTTP Header: {}", entry.getKey() + ": " + entry.getValue());
            }

            if (idempotencyKey != null && !idempotencyKey.trim().isEmpty()) {
                connection.addRequestProperty("Idempotency-Key", idempotencyKey);
            }

            // prepare to go
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            if (pagination != null) {
                this.pagination = pagination;
            }

            if (this.debugMode)
                logger.info("RequestType: {}", this.requestType);

            if (this.requestData != null || entity != null) {

                String requestBody = "";
                if (entity != null) {
                    HashMap<String, Object> requestData = buildRequestData(classOfT, entity);

                    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                    requestBody = gson.toJson(requestData);
                }
                if (this.requestData != null) {
                    String params = "";
                    for (Entry<String, String> entry : this.requestData.entrySet()) {
                        params += String.format("&%s=%s", URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
                    }
                    requestBody = params.replaceFirst("&", "");
                }

                if (this.debugMode) {
                    logger.info("RequestData: {}", this.requestData);
                    logger.info("RequestBody: {}", requestBody);
                }

                try (OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream(), "UTF-8")) {
                    osw.write(requestBody);
                    osw.flush();
                }
            }


            // get response
            this.responseCode = connection.getResponseCode();
            InputStream is;
            if (this.responseCode != 200 && this.responseCode != 204) {
                is = connection.getErrorStream();
            } else {
                is = connection.getInputStream();
            }

            StringBuffer resp;
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
                String line;
                resp = new StringBuffer();
                while ((line = rd.readLine()) != null) {
                    resp.append(line);
                }
            }
            String responseString = resp.toString();

            if (this.debugMode) {
                if (this.responseCode == 200 || this.responseCode == 204) {
                    logger.info("Response OK: {}", responseString);
                } else {
                    logger.info("Response ERROR: {}", responseString);
                }
            }

            if (this.responseCode == 200) {

                this.readResponseHeaders(connection);

                response = castResponseToEntity(classOfT, new JsonParser().parse(responseString).getAsJsonObject());

                if (this.debugMode) logger.info("Response object: {}", response.toString());
            }

            this.checkResponseCode(responseString);

        } catch (Exception ex) {
            //ex.printStackTrace();
            if (this.debugMode) logger.error("EXCEPTION: {}", Arrays.toString(ex.getStackTrace()));
            throw ex;
        }

        return response;
    }

    private void readResponseHeaders(HttpURLConnection conn) {
        for (Map.Entry<String, List<String>> k : conn.getHeaderFields().entrySet()) {
            for (String v : k.getValue()) {

                if (this.debugMode) logger.info("Response header: {}", k.getKey() + ":" + v);

                if (k.getKey() == null) continue;

                if (k.getKey().equals("X-Number-Of-Pages")) {
                    this.pagination.setTotalPages(Integer.parseInt(v));
                }
                if (k.getKey().equals("X-Number-Of-Items")) {
                    this.pagination.setTotalItems(Integer.parseInt(v));
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
                                    this.pagination.setLinks(oneLink);
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

        List<Field> fields = getAllFields(entity.getClass());

        String fieldName;
        for (Field f : fields) {
            f.setAccessible(true);

            boolean isList = false;
            for (Class<?> i : f.getType().getInterfaces()) {
                if (i.getName().equals("java.util.List")) {
                    isList = true;
                    break;
                }
            }

            fieldName = fromCamelCase(f.getName());

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
                    subRequestData = (HashMap<String, Object>) m.invoke(this, f.getType(), f.get(entity));
                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    if (this.debugMode) logger.error("EXCEPTION: {}", Arrays.toString(ex.getStackTrace()));
                }

                for (Entry<String, Object> e : subRequestData.entrySet()) {
                    result.put(e.getKey(), e.getValue());
                }
            } else {
                try {
                    if (!isList) {
                        result.put(fieldName, f.get(entity));
                    } else {
                        result.put(fieldName, ((List) f.get(entity)).toArray());
                    }
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    continue;
                }
            }

        }

        return result;
    }

    private List<Field> getAllFields(Class<?> c) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(c.getDeclaredFields()));
        while (c.getSuperclass() != null) {
            fields.addAll(Arrays.asList(c.getSuperclass().getDeclaredFields()));
            c = c.getSuperclass();
        }
        return fields;
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

        if (classOfT.getName().equals(BankingAlias.class.getName()) && fieldName.equals("Details")) {
            return true;
        }

        return false;

    }

    public <T> T castResponseToEntity(Class<T> classOfT, JsonObject response) throws Exception {
        return castResponseToEntity(classOfT, response, false);
    }

    private <T> T castResponseToEntity(Class<T> classOfT, JsonObject response, boolean asDependentObject) throws Exception {

        try {

            if (debugMode) {
                logger.info("Entity type: {}", classOfT.getName());
            }

            if (classOfT.getName().equals(IdempotencyResponse.class.getName())) {

                // handle the special case here
                IdempotencyResponse resp = new IdempotencyResponse();

                for (Entry<String, JsonElement> entry : response.entrySet()) {

                    if (entry.getKey().equals("StatusCode")) {
                        resp.setStatusCode(entry.getValue().getAsString());
                    } else if (entry.getKey().equals("ContentLength")) {
                        resp.setContentLength(entry.getValue().getAsString());
                    } else if (entry.getKey().equals("ContentType")) {
                        resp.setContentType(entry.getValue().getAsString());
                    } else if (entry.getKey().equals("Date")) {
                        resp.setDate(entry.getValue().getAsString());
                    } else if (entry.getKey().equals("Resource")) {
                        resp.setResource(entry.getValue().toString());
                    } else if (entry.getKey().equals("RequestURL")) {
                        resp.setRequestUrl(entry.getValue().toString());
                    }

                }

                return (T) resp;
            }

            T result = null;

            if (classOfT.getName().equals(User.class.getName())) {
                for (Entry<String, JsonElement> entry : response.entrySet()) {

                    if (entry.getKey().equals("PersonType")) {
                        String userType = entry.getValue().getAsString();

                        if (userType.equals(PersonType.NATURAL.toString())) {
                            result = (T) new UserNatural();
                            break;
                        } else if (userType.equals(PersonType.LEGAL.toString())) {
                            result = (T) new UserLegal();
                            break;
                        } else {
                            throw new Exception(String.format("Unknown type of user: %s", entry.getValue().getAsString()));
                        }
                    }

                }
            } else {
                result = classOfT.newInstance();
            }

            Map<String, Type> subObjects = ((Dto) result).getSubObjects();
            Map<String, Map<String, Map<String, Class<?>>>> dependentObjects = ((Dto) result).getDependentObjects();

            List<Field> fields = getAllFields(result.getClass());

            for (Field f : fields) {
                f.setAccessible(true);
                String name = fromCamelCase(f.getName());

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

                                    Field targetField = classOfT.getDeclaredField(toCamelCase(e.getKey()));
                                    targetField.setAccessible(true);

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
                            } else {
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

                        if (debugMode) {
                            logger.info("Recognized field: {}", String.format("[%s] %s%s", name, fieldTypeName, fieldIsArray ? "[]" : ""));
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
                                    } else if (genericTypeClass.getName().equals(int.class.getName())
                                            || genericTypeClass.getName().equals(Integer.class.getName())) {
                                        addMethod.invoke(o, e.getAsJsonPrimitive().getAsInt());
                                    } else if (genericTypeClass.getName().equals(long.class.getName())
                                            || genericTypeClass.getName().equals(Long.class.getName())) {
                                        addMethod.invoke(o, e.getAsJsonPrimitive().getAsLong());
                                    } else if (genericTypeClass.getName().equals(double.class.getName())
                                            || genericTypeClass.getName().equals(Double.class.getName())) {
                                        addMethod.invoke(o, e.getAsJsonPrimitive().getAsDouble());
                                    } else if (genericTypeClass.isEnum()) {// Enumeration, try getting enum by name
                                        Class cls = genericTypeClass;
                                        Object val = Enum.valueOf(cls, e.getAsJsonPrimitive().getAsString());
                                        addMethod.invoke(o, val);
                                    }
                                }
                                f.set(result, o);
                            }
                        } else {
                            if (!entry.getValue().isJsonNull()) {
                                if (fieldTypeName.equals(int.class.getName())) {
                                    f.setInt(result, entry.getValue().getAsInt());
                                } else if (fieldTypeName.equals(Integer.class.getName())) {
                                    f.set(result, entry.getValue().getAsInt());
                                } else if (fieldTypeName.equals(long.class.getName())) {
                                    f.setLong(result, entry.getValue().getAsLong());
                                } else if (fieldTypeName.equals(Long.class.getName())) {
                                    f.set(result, entry.getValue().getAsLong());
                                } else if (fieldTypeName.equals(double.class.getName())) {
                                    f.setDouble(result, entry.getValue().getAsDouble());
                                } else if (fieldTypeName.equals(Double.class.getName())) {
                                    f.set(result, entry.getValue().getAsDouble());
                                } else if (fieldTypeName.equals(String.class.getName())) {
                                    f.set(result, entry.getValue().getAsString());
                                } else if (fieldTypeName.equals(boolean.class.getName())) {
                                    f.setBoolean(result, entry.getValue().getAsBoolean());
                                } else if (fieldTypeName.equals(Boolean.class.getName())) {
                                    f.set(result, entry.getValue().getAsBoolean());
                                } else if (f.getType().isEnum()) {// Enumeration, try getting enum by name
                                    Class cls = f.getType();
                                    Object val = Enum.valueOf(cls, entry.getValue().getAsString());
                                    f.set(result, val);
                                }
                            }

                            break;
                        }
                    }

                }

            }

            if (classOfT.getName().equals(Address.class.getName())) {
                if (!((Address) result).isValid()) result = null;
            }

            return result;

        } catch (Exception e) {
            if (this.debugMode) logger.error("EXCEPTION: {}", Arrays.toString(e.getStackTrace()));

            throw e;
        }

    }

    private String toCamelCase(String fieldName) {
        if (fieldName.toUpperCase().equals(fieldName)) {
            return fieldName.toLowerCase();
        }
        String camelCase = (fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1, fieldName.length())).replace("URL", "Url").replace("AVS", "Avs");
        while (camelCase.contains("_")) {
            int index = camelCase.indexOf("_");
            String letterAfter = ("" + camelCase.charAt(index + 1)).toUpperCase();
            camelCase = camelCase.substring(0, index) + letterAfter + camelCase.substring(index + 2);
        }
        return camelCase;
    }

    private String fromCamelCase(String fieldName) {
        if (fieldName.equals("iban") || fieldName.equals("bic") || fieldName.equals("aba")) {
            return fieldName.toUpperCase();
        }
        if (fieldName.equals("accessToken")) {
            return "access_token";
        }
        if (fieldName.equals("tokenType")) {

            return "token_type";
        }
        if (fieldName.equals("expiresIn")) {
            return "expires_in";
        }
        if (fieldName.equals("url")) {
            return "Url";
        }
        return (fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1)).replace("Url", "URL").replace("Avs", "AVS");
    }

    private <T extends Dto> List<T> doRequestList(Class<T[]> classOfT, Class<T> classOfTItem, String urlMethod, Pagination pagination) throws Exception {
        return doRequestList(classOfT, classOfTItem, urlMethod, pagination, null);
    }

    private <T extends Dto> List<T> doRequestList(Class<T[]> classOfT, Class<T> classOfTItem, String urlMethod, Pagination pagination, Map<String, String> additionalUrlParams) throws Exception {

        List<T> response = new ArrayList<>();

        try {
            UrlTool urlTool = new UrlTool(root);
            String restUrl = urlTool.getRestUrl(urlMethod, this.authRequired, pagination, additionalUrlParams);

            URL url = new URL(urlTool.getFullUrl(restUrl));

            if (this.debugMode)
                logger.info("FullUrl: {}", urlTool.getFullUrl(restUrl));

            connection = (HttpURLConnection) url.openConnection();

            // set request method
            connection.setRequestMethod(this.requestType);

            // set headers
            Map<String, String> httpHeaders = this.getHttpHeaders(restUrl);

            for (Entry<String, String> entry : httpHeaders.entrySet()) {
                connection.addRequestProperty(entry.getKey(), entry.getValue());

                if (this.debugMode)
                    logger.info("HTTP Header: {}", entry.getKey() + ": " + entry.getValue());
            }

            // prepare to go
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            if (pagination != null) {
                this.pagination = pagination;
            }

            if (this.debugMode)
                logger.info("RequestType: {}", this.requestType);

            if (this.requestData != null) {

                String requestBody;
                String params = "";
                for (Entry<String, String> entry : this.requestData.entrySet()) {
                    params += String.format("&%s=%s", URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
                requestBody = params.replaceFirst("&", "");

                try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                    wr.writeBytes(requestBody);
                    wr.flush();
                }

                if (this.debugMode) {
                    logger.info("RequestData: {}", this.requestData);
                    logger.info("RequestBody: {}", requestBody);
                }
            }


            //Get Response	
            this.responseCode = connection.getResponseCode();
            InputStream is;
            if (this.responseCode != 200) {
                is = connection.getErrorStream();
            } else {
                is = connection.getInputStream();
            }

            StringBuffer resp;
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
                String line;
                resp = new StringBuffer();
                while ((line = rd.readLine()) != null) {
                    resp.append(line);
                    resp.append('\r');
                }
            }
            String responseString = resp.toString();

            if (this.debugMode) {
                if (this.responseCode == 200) {
                    logger.info("Response OK: {}", responseString);
                } else {
                    logger.info("Response ERROR: {}", responseString);
                }
            }

            if (this.responseCode == 200) {

                this.readResponseHeaders(connection);

                JsonArray ja = new JsonParser().parse(responseString).getAsJsonArray();

                for (int x = 0; x < ja.size(); x++) {
                    JsonObject jo = ja.get(x).getAsJsonObject();
                    T toAdd = castResponseToEntity(classOfTItem, jo);
                    response.add(toAdd);
                }

                if (this.debugMode) {
                    logger.info("Response object: {}", response.toString());
                    logger.info("Elements count: {}", response.size());
                }
            }

            this.checkResponseCode(responseString);

        } catch (Exception ex) {
            if (this.debugMode) logger.error("EXCEPTION: {}", Arrays.toString(ex.getStackTrace()));
            throw ex;
        }

        return response;

    }

    /**
     * Gets HTTP header to use in request.
     *
     * @param restUrl The REST API URL.
     * @return Array containing HTTP headers.
     */
    private Map<String, String> getHttpHeaders(String restUrl) throws Exception {
        // return if already created...
        if (this.requestHttpHeaders != null)
            return this.requestHttpHeaders;

        // ...or initialize with default headers
        Map<String, String> httpHeaders = new HashMap<>();

        // content type
        httpHeaders.put("Content-Type", "application/json");

        // AuthenticationHelper http header
        if (this.authRequired) {
            AuthenticationHelper authHlp = new AuthenticationHelper(root);
            httpHeaders.putAll(authHlp.getHttpHeaderKey());
        }

        return httpHeaders;
    }

    /**
     * Checks the HTTP response code and if it's neither 200 nor 204 throws a ResponseException.
     *
     * @param message Text response.
     * @throws ResponseException If response code is other than 200 or 204.
     */
    private void checkResponseCode(String message) throws ResponseException {

        if (this.responseCode != 200 && this.responseCode != 204) {

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

            ResponseException responseException = new ResponseException(message);
            responseException.setResponseHttpCode(this.responseCode);

            if (responseCodes.containsKey(this.responseCode)) {
                responseException.setResponseHttpDescription(responseCodes.get(this.responseCode));
            } else {
                responseException.setResponseHttpDescription("Unknown response error");
            }

            if (message != null) {
                JsonObject error = new JsonParser().parse(message).getAsJsonObject();
                for (Entry<String, JsonElement> entry : error.entrySet()) {

                    switch (entry.getKey().toLowerCase()) {
                        case "message":
                            responseException.setApiMessage(entry.getValue().getAsString());
                            break;
                        case "type":
                            responseException.setType(entry.getValue().getAsString());
                            break;
                        case "id":
                            responseException.setId(entry.getValue().getAsString());
                            break;
                        case "date":
                            responseException.setDate((int) entry.getValue().getAsDouble());
                            break;
                        case "errors":
                            if (entry.getValue() == null) break;

                            if (entry.getValue().isJsonNull()) break;

                            for (Entry<String, JsonElement> errorEntry : entry.getValue().getAsJsonObject().entrySet()) {
                                if (!responseException.getErrors().containsKey(errorEntry.getKey()))
                                    responseException.getErrors().put(errorEntry.getKey(), errorEntry.getValue().getAsString());
                                else {
                                    String description = responseException.getErrors().get(errorEntry.getKey());
                                    description = " | " + errorEntry.getValue().getAsString();

                                    responseException.getErrors().put(errorEntry.getKey(), description);
                                }
                            }
                            break;
                    }
                }
            }

            throw responseException;
        }
    }
}
