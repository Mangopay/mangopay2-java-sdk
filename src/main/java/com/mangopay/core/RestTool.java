package com.mangopay.core;

import com.google.gson.*;
import com.mangopay.MangoPayApi;
import com.mangopay.core.enumerations.RequestType;
import com.mangopay.entities.RateLimit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
    private boolean debugMode;

    // variable to flag that in request authentication data are required
    private boolean authRequired;

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
     */
    public RestTool(MangoPayApi root, Boolean authRequired) {
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
        addRequestHttpHeader(Collections.singletonMap(key, value));
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
    public <T extends Dto, U extends Dto> T request(Class<T> classOfT, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination, U entity) throws Exception {
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
    public <T extends Dto, U extends Dto> T request(Class<T> classOfT, String idempotencyKey, String urlMethod, String requestType, Map<String, String> requestData, Pagination pagination, U entity) throws Exception {

        this.requestType = requestType;
        this.requestData = requestData;

        return this.doRequest(classOfT, idempotencyKey, urlMethod, pagination, entity);
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

        return this.doRequestList(classOfT, classOfTItem, urlMethod, pagination, additionalUrlParams);
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

    private <T extends Dto, U extends Dto> T doRequest(Class<T> classOfT, String idempotencyKey, String urlMethod, Pagination pagination, U entity) throws Exception {

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
            if (connection instanceof HttpsURLConnection) {
                configureSslContext((HttpsURLConnection) connection);
            }
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

            if (this.requestData != null || entity != null || this.requestType.equals(RequestType.POST.toString())) {

                String requestBody = "";
                if (entity != null) {
                    requestBody = root.getGson().toJson(entity);
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

                response = castResponseToEntity(classOfT, JsonParser.parseString(responseString).getAsJsonObject());

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

    private void configureSslContext(HttpsURLConnection connection) throws KeyManagementException, NoSuchAlgorithmException {
        connection.setSSLSocketFactory(getSSLContext().getSocketFactory());
    }

    private SSLContext getSSLContext() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, null, new SecureRandom());
        return sslContext;
    }

    private void readResponseHeaders(HttpURLConnection conn) {
        List<RateLimit> updatedRateLimits = null;
        for (Map.Entry<String, List<String>> k : conn.getHeaderFields().entrySet()) {
            for (String v : k.getValue()) {

                if (this.debugMode) logger.info("Response header: {}", k.getKey() + ":" + v);

                if (k.getKey() == null) continue;

                if (k.getKey().equals("X-RateLimit-Remaining") || k.getKey().equals("X-RateLimit-Remaining".toLowerCase())) {
                    if (updatedRateLimits == null) {
                        updatedRateLimits = initRateLimits();
                    }
                    List<String> callsRemaining = k.getValue();
                    updatedRateLimits.get(0).setCallsRemaining(Integer.valueOf(callsRemaining.get(3)));
                    updatedRateLimits.get(1).setCallsRemaining(Integer.valueOf(callsRemaining.get(2)));
                    updatedRateLimits.get(2).setCallsRemaining(Integer.valueOf(callsRemaining.get(1)));
                    updatedRateLimits.get(3).setCallsRemaining(Integer.valueOf(callsRemaining.get(0)));
                }
                if (k.getKey().equals("X-RateLimit") || k.getKey().equals("X-RateLimit".toLowerCase())) {
                    if (updatedRateLimits == null) {
                        updatedRateLimits = initRateLimits();
                    }
                    List<String> callsMade = k.getValue();
                    updatedRateLimits.get(0).setCallsMade(Integer.valueOf(callsMade.get(3)));
                    updatedRateLimits.get(1).setCallsMade(Integer.valueOf(callsMade.get(2)));
                    updatedRateLimits.get(2).setCallsMade(Integer.valueOf(callsMade.get(1)));
                    updatedRateLimits.get(3).setCallsMade(Integer.valueOf(callsMade.get(0)));
                }
                if (k.getKey().equals("X-RateLimit-Reset") || k.getKey().equals("X-RateLimit-Reset".toLowerCase())) {
                    if (updatedRateLimits == null) {
                        updatedRateLimits = initRateLimits();
                    }
                    List<String> resetTimes = k.getValue();
                    updatedRateLimits.get(0).setResetTimeMillis(Long.valueOf(resetTimes.get(3)));
                    updatedRateLimits.get(1).setResetTimeMillis(Long.valueOf(resetTimes.get(2)));
                    updatedRateLimits.get(2).setResetTimeMillis(Long.valueOf(resetTimes.get(1)));
                    updatedRateLimits.get(3).setResetTimeMillis(Long.valueOf(resetTimes.get(0)));
                }
                if (k.getKey().equals("X-Number-Of-Pages") || k.getKey().equals("X-Number-Of-Pages".toLowerCase())) {
                    this.pagination.setTotalPages(Integer.parseInt(v));
                }
                if (k.getKey().equals("X-Number-Of-Items") || k.getKey().equals("X-Number-Of-Items".toLowerCase())) {
                    this.pagination.setTotalItems(Integer.parseInt(v));
                }
                if (k.getKey().equals("Link") || k.getKey().equals("Link".toLowerCase())) {
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
        if (updatedRateLimits != null) {
            root.setRateLimits(updatedRateLimits);
        }
    }

    private List<RateLimit> initRateLimits() {
        return Arrays.asList(
                new RateLimit(15),
                new RateLimit(30),
                new RateLimit(60),
                new RateLimit(24 * 60));
    }

    public <T> T castResponseToEntity(Class<T> classOfT, JsonObject response) {
        return root.getGson().fromJson(response, classOfT);
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

            if (connection instanceof HttpsURLConnection) {
                configureSslContext((HttpsURLConnection) connection);
            }

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

                writeRequestBody(connection, requestBody);

                if (this.debugMode) {
                    logger.info("RequestData: {}", this.requestData);
                    logger.info("RequestBody: {}", requestBody);
                }
            } else if (restUrl.contains("consult")
                    && (restUrl.contains("KYC/documents") || restUrl.contains("dispute-documents"))) {
                writeRequestBody(connection, "");
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

                JsonArray ja = JsonParser.parseString(responseString).getAsJsonArray();

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

    private void writeRequestBody(HttpURLConnection connection, String body) throws IOException {
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.writeBytes(body);
            wr.flush();
        }
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
                try {
                    JsonObject error = JsonParser.parseString(message).getAsJsonObject();
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
                } catch (IllegalStateException | JsonSyntaxException ex) {
                    responseException.setType("Resource not found");
                    responseException.setApiMessage("API Endpoint not found");
                }
            }

            throw responseException;
        }
    }
}
