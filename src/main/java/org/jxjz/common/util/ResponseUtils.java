package org.jxjz.common.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;



public final class ResponseUtils
{

  public static void renderText(HttpServletResponse response, String text)
  {
    render(response, "text/html;charset=UTF-8", text);
  }

  public static void renderJson(HttpServletResponse response, String text)
  {
    render(response, "application/json;charset=UTF-8", text);
  }

  public static void renderXml(HttpServletResponse response, String text)
  {
    render(response, "text/xml;charset=UTF-8", text);
  }

  public static void render(HttpServletResponse response, String contentType, String text)
  {
	System.out.println(text);
    response.setContentType(contentType);
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma", "no-cache");
    try {
      response.getWriter().write(text);
	  response.getWriter().flush();
	  response.getWriter().close();
    } catch (IOException e) {
    }
  }
}