package com.ellis.spyder;

import java.io.BufferedReader;
import java.io.File;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;


/*******************************************************************************
*
*<b>Title:</b> Connection.java
*<b>Project:</b> Spyder
*<b>Description:</b> This is the connection class that will handle connections 
*to servers based on http vs https
*<b>Copyright:</b> Copyright (c) 2022
*<b>Company:</b> Silicon Mountain Technologies
*@author Cameron Ellis
*@version 3.1
*@since Jun 15, 2022
*<b>updates:</b>
*
******************************************************************************/

// conn.getRequestProperties();


public class Connection {


//	Path filePath = Paths.get("smt.html");
//	File thisFile = new File("MySocket.java");
//	File htmlFile = new File("smt.html");
	private URL url;
	private int port;
	private String cookie;
	
	/**
	 * 
	 */
	public Connection() {
		super();
	}
<<<<<<< HEAD
=======
	

>>>>>>> fc3a2415e7b0f06b361d079af609cc1ae440e9bb

	/**
	 * @param url
	 * @param port
	 */
	public Connection(URL url, int port) {
		super();
		this.url = url;
		this.port = port;
	}

	/**
	 * @param host
	 * @param portNumber
	 * @return string of html to be parsed by jsoup
	 * @throws Exception
	 */
	public String getWebPage(URL host) throws Exception {
		
		// if check to see if host.matches 
		
//        String httpsURL = host;
//        URL myUrl = new URL(httpsURL);
        HttpsURLConnection getConn = (HttpsURLConnection)host.openConnection();
        InputStream is = getConn.getInputStream();
        
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String inputLine;
		
		StringBuilder html = new StringBuilder();
		Map<String, List<String>> headerFields = getConn.getHeaderFields();
        String cookieField = getConn.getHeaderField("Set-Cookie");
        
        if (this.cookie == null) {
        	this.cookie = getConn.getHeaderField("Set-Cookie");
        }
        
        System.out.println("HFs-- " + headerFields);
        System.out.println("HF5-- " + cookieField);
        System.out.println("cookie-- " + this.cookie);
		
        while ((inputLine = br.readLine()) != null) {
        	html.append(inputLine).append("\n");
        }
        
        br.close();
        
        System.out.println("html~> " + html);
		return html.toString();
	}
	
	/**
	 * method overloading to handle two urls for widget admin - will call 
	 * other getWebPage method if login post was successful 
	 * @param login
	 * @param widget
	 * @param port
	 * @return string of html to be parsed by jsoup
	 * @throws Exception 
	 */
	public String postWidget(URL login, URL widget) throws Exception {
		
//        URL loginUrl = new URL(login);
//        URL widgetUrl = new URL(widget);
		
		// post function to login - if status == 200 - getwebpage(widget)
		// html1 = getWebPage()
		// html2 = getWebPage()
        
        HttpsURLConnection postConn = (HttpsURLConnection)login.openConnection();
        InputStream is = postConn.getInputStream();
        
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String inputLine;
        
		
		Map<String, List<String>> headerFields = postConn.getHeaderFields();
        String cookieField = postConn.getHeaderField("Set-Cookie");
        StringBuilder html = new StringBuilder();
        
        System.out.println("HF-- " + headerFields);
        System.out.println("HF5-- " + cookieField);
		
        while ((inputLine = br.readLine()) != null) {
        	html.append(inputLine).append("\n");
//        	System.out.println("html> " + inputLine);
        }
        
        br.close();
        
        System.out.println("html~> " + html);
        
        String html1 = getWebPage(widget);
        
		return html1;
	}
	
	/**
	 * @return the cookie
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	
	/**
	 * @return the cookie
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	
	/**
	 * @return the url
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(URL url) {
		this.url = url;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
}

// ------ THIS WORKS FOR SMT HOMEPAGE ------
//public static void main(String[] args) throws Exception {
//    String httpsURL = "https://www.siliconmtn.com";
//    URL myUrl = new URL(httpsURL);
//    HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
//    InputStream is = conn.getInputStream();
//    InputStreamReader isr = new InputStreamReader(is);
//    BufferedReader br = new BufferedReader(isr);
//
//    String inputLine;
//
//    while ((inputLine = br.readLine()) != null) {
//        System.out.println(inputLine);
//    }
//
//    br.close();
//}


// -- response object example ? -- 
// HTTP/1.1 404 404
//Date: Mon, 20 Jun 2022 15:49:25 GMT
//Content-Type: text/html;charset=UTF-8
//Content-Length: 11590
//Connection: close
//Set-Cookie: AWSALB=fX8auHzDtnvKw5XtuKvfFFIMVw+whNK/7YM7Nuc1pxT0LZQJ3KMpffRTfJRc9IQ0LxLX/orC52gRXA9rqvUlQGWyaaecTqU82qH7IgSNAgxfjlMzDjwEfpZkKKt8; Expires=Mon, 27 Jun 2022 15:49:25 GMT; Path=/
//Set-Cookie: AWSALBCORS=fX8auHzDtnvKw5XtuKvfFFIMVw+whNK/7YM7Nuc1pxT0LZQJ3KMpffRTfJRc9IQ0LxLX/orC52gRXA9rqvUlQGWyaaecTqU82qH7IgSNAgxfjlMzDjwEfpZkKKt8; Expires=Mon, 27 Jun 2022 15:49:25 GMT; Path=/; SameSite=None; Secure
//Server: Apache/2.4.39 (Amazon) OpenSSL/1.0.2k-fips
//X-Frame-Options: SAMEORIGIN
//Set-Cookie: JSESSIONID=5D33BCC20EB660F96C08EAECCCA0DE3E; Path=/; Secure; HttpOnly

//try {
//	SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
//	SSLSocket socket = (SSLSocket) factory.createSocket("www.siliconmtn.com", 443);
//
//	/*
//	 * send http request
//	 *
//	 * Before any application data is sent or received, the SSL socket will do SSL
//	 * handshaking first to set up the security attributes.
//	 *
//	 * SSL handshaking can be initiated by either flushing data down the pipe, or by
//	 * starting the handshaking by hand.
//	 *
//	 * Handshaking is started manually in this example because PrintWriter catches
//	 * all IOExceptions (including SSLExceptions), sets an internal error flag, and
//	 * then returns without rethrowing the exception.
//	 *
//	 * Unfortunately, this means any error messages are lost, which caused lots of
//	 * confusion for others using this code. The only way to tell there was an error
//	 * is to call PrintWriter.checkError().
//	 */
//	socket.startHandshake();
//
//	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
//
//	out.println("GET / HTTP/1.0");
//	out.println();
//	out.flush();
//
//	/*
//	 * Make sure there were no surprises
//	 */
//	if (out.checkError())
//		System.out.println("SSLSocketClient:  java.io.PrintWriter error");
//
//	/* read response */
//	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//	String inputLine;
//	while ((inputLine = in.readLine()) != null)
//		System.out.println(inputLine);
//
//	in.close();
//	out.close();
//	socket.close();
//
//} catch (Exception e) {
//	e.printStackTrace();
//}

// ~~~ 
//String httpsURL = "https://www.siliconmtn.com/contact";
//URL myUrl = new URL(httpsURL);
//
//HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
//InputStream is = conn.getInputStream();
//
//InputStreamReader isr = new InputStreamReader(is);
//BufferedReader br = new BufferedReader(isr);
//
//StringBuilder header = new StringBuilder();
//StringBuilder html = new StringBuilder();
//String inputLine;
//String headerLine;
//
//Map<String, List<String>> headerFields = conn.getHeaderFields();
//String headerField5 = conn.getHeaderField("Set-Cookie");
//
//System.out.println("HF-- " + headerFields);
//System.out.println("HF5-- " + headerField5);
////System.out.println("CONTENT-- " + conn.getContent());
//
////while ((headerLine = conn.getHeaderField()) != null && inputLine.length() > 0) {
////	header.append(inputLine);
////    System.out.println("header >>> " + inputLine);
////}
//while ((inputLine = br.readLine()) != null) {
//	html.append(inputLine);
////	System.out.println("html> " + inputLine);
//}
//
//br.close();
