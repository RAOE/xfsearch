package com.xuyuanfeng.utlis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.util.HtmlUtils;
/**
 * 用于切割html字符，以及html解码和转码 防止xss攻击
 */
public class HTMLUtils {
	public static String delHTMLTag(String htmlStr){ 
		//如果为null 或者为 空  则定义为空字符
		if(htmlStr==null||htmlStr.equals(""))
		{
			return "";
		}
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 

        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

        return htmlStr.trim(); //返回文本字符串 
}

	
	
	public static String stripHtml(String content) { 
		// <p>段落替换为换行 
		content = content.replaceAll("<p .*?>", "\r\n"); 
		// <br><br/>替换为换行 
		content = content.replaceAll("<br\\s*/?>", "\r\n"); 
		// 去掉其它的<>之间的东西 
		content = content.replaceAll("\\<.*?>", ""); 
		// 还原HTML 
		return content; 
		}
//转码
	 public static String htmlescape(String html){  
		    String tmp = HtmlUtils.htmlEscapeDecimal(html);  
			return tmp;  
	    }  
//解码
	 public static String htmlUnescape(String enhtml){  
		  
		    String value = HtmlUtils.htmlUnescape(enhtml);  
			return value;  
	    }  
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
