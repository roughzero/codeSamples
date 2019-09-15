/*
 * Created on 2015年12月4日
 */
package sample.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SampleOfHttpClient {

    private static final String DEFAULT_CHARSET = "UTF-8";

    /**   
     * 程序中访问http数据接口   
     */
    public static String getURLContent(String urlStr) throws IOException {

        StringBuffer sb = new StringBuffer();
        URL url = new URL(urlStr);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), DEFAULT_CHARSET));

        String str = null;
        while ((str = in.readLine()) != null) {
            sb.append(str);
            sb.append("\n");
        }

        if (in != null) {
            in.close();
        }

        String result = sb.toString();
        return result;
    }

    /**  
    * post方式请求http服务  
    * @param urlStr  
    * @param params   name=yxd&age=25  
    * @return  
    * @throws Exception  
    */
    public static String getURLByPost(String urlStr, String params) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
        printWriter.write(params);
        printWriter.flush();
        BufferedReader in = null;
        StringBuilder sb = new StringBuilder();
        try {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String str = null;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                conn.disconnect();
                if (in != null) {
                    in.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException ex) {
                throw ex;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String content = null;
        try {
            content = getURLContent("http://localhost:7001/console");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            content = getURLByPost("http://localhost:7001/console/j_security_check", "j_username=weblogic&j_password=weblogic");
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
