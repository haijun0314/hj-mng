package org.jxjz.framework.search.solr;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public class SolrUtil {
//	private String solrServerUrl;//solr服务器URL
//	private CommonsHttpSolrServer server = null;
//	
//	public  SolrServer getSolrServer(){
//		if (server==null) {
//			synchronized (CommonsHttpSolrServer.class) {
//				if (server==null) {
//					try {
//						solrServerUrl=MsgUtil.getMsgString("search.solr.serverUrl");
//						server = new CommonsHttpSolrServer( solrServerUrl );
//						server.setParser(new XMLResponseParser());
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		return server;
//	}
//	/**
//	 * 生成索引
//	 */
//	public void createIndex(SolrInputDocument doc) {
//		try {
//			SolrServer server = getSolrServer();
//			server.add(doc);
//			server.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	 
//	}		
//	
//	/**
//	 * 生成索引
//	 */
//	public void createIndex(List<HashMap> dataList) {
//		try {
//			SolrServer server = getSolrServer();
//			Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
//			for (int i = 0; i < dataList.size(); i++) {
//				SolrInputDocument doc = new SolrInputDocument();
//				Map map =(HashMap)dataList.get(i);
//				Iterator it = map.keySet().iterator();
//				while (it.hasNext())
//				{
//					String key = (String) it.next();
//					Object val = map.get(key);
//					if (val == null)continue;
//					doc.addField(key, val);
//				}
//				docs.add(doc);
//			}
//			server.add( docs );
//			server.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	 
//	}	
//	/**
//	 * 【查询索引  分页】
//	 */
//	public PageModel getIndexListPM(PageModel pm) {
//		// 得到一个 SolrServer 实例（通过上面介绍的方法创建）
//		SolrServer server = getSolrServer();
//		// 构造一个查询对象
//		SolrQuery query = new SolrQuery();
//		query.setQuery( pm.getQueryStr());
//		query.setRows(pm.getPageSize());
//		query.setStart(pm.getStartRow());
//		QueryResponse rsp;
//		SolrDocumentList docs=null;
//		try {
//			rsp = server.query(query);
//			docs = rsp.getResults();
//		} catch (SolrServerException e) {
//			e.printStackTrace();
//		}
//		Long total=docs.getNumFound();
//		pm.setDatas(docs);
//		pm.setTotalRows(total.intValue());
//		return pm;
//	}
//	
//	/**
//	 * 【查询索引  不分页】
//	 */
//	public List<SolrDocument>  getIndexList(String  queryStr) {
//		SolrServer server = getSolrServer();
//		// 构造一个查询对象
//		SolrQuery query = new SolrQuery();
//		query.setQuery(queryStr);
//		QueryResponse rsp;
//		SolrDocumentList docs=null;
//		try {
//			rsp = server.query(query);
//			docs = rsp.getResults();
//		} catch (SolrServerException e) {
//			e.printStackTrace();
//		}
//		return docs;
//	}	
//	 
	 
}
