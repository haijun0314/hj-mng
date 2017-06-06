package org.jxjz.framework.search.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.jxjz.base.model.PageModel;
import org.jxjz.framework.util.ConfigUtil;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class SolrUtil {
	private String solrServerUrl;//solr服务器URL
	private HttpSolrClient server = null;
	
	public  HttpSolrClient getSolrServer(){
		if (server==null) {
			synchronized (HttpSolrClient.class) {
				if (server==null) {
					try {
						solrServerUrl=ConfigUtil.server_solr_host_url+"/my_solr";
						server = new HttpSolrClient( solrServerUrl );
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return server;
	}
	/**
	 * 生成索引
	 */
	public void createIndex(SolrInputDocument doc) {
		try {
			HttpSolrClient server = getSolrServer();
			server.add(doc);
			server.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}	 
	}		
	
	/**
	 * 生成索引
	 */
	public void createIndex(List<HashMap> dataList) {
		try {
			HttpSolrClient server = getSolrServer();
			Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
			for (int i = 0; i < dataList.size(); i++) {
				SolrInputDocument doc = new SolrInputDocument();
				Map map =(HashMap)dataList.get(i);
				Iterator it = map.keySet().iterator();
				while (it.hasNext())
				{
					String key = (String) it.next();
					Object val = map.get(key);
					if (val == null)continue;
					doc.addField(key, val);
				}
				docs.add(doc);
			}
			server.add( docs );
			server.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}	 
	}	
	/**
	 * 【查询索引  分页】
	 * @throws IOException 
	 */
	public PageModel getIndexListPM(PageModel pm) throws IOException {
		// 得到一个 SolrServer 实例（通过上面介绍的方法创建）
		HttpSolrClient server = getSolrServer();
		// 构造一个查询对象
		SolrQuery query = new SolrQuery();
		query.set("q", "*:*");
//		query.setQuery( pm.getQueryStr());
		query.setRows(pm.getPageSize());
		query.setStart(pm.getStartRow());
		QueryResponse rsp;
		SolrDocumentList docs=null;
		try {
			rsp = server.query(query);
			docs = rsp.getResults();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		Long total=docs.getNumFound();
		pm.setDatas(docs);
		pm.setTotalRows(total.intValue());
		return pm;
	}
	
	/**
	 * 【查询索引  不分页】
	 * @throws IOException 
	 */
	public List<SolrDocument>  getIndexList(String  queryStr) throws IOException {
		HttpSolrClient server = getSolrServer();
		// 构造一个查询对象
		SolrQuery query = new SolrQuery();
		query.setQuery(queryStr);
		QueryResponse rsp;
		SolrDocumentList docs=null;
		try {
			rsp = server.query(query);
			docs = rsp.getResults();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return docs;
	}	
	 
	 
}
