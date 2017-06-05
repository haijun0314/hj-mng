<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/cssandjs.jsp"%>
<script src="/static/colorbox/jquery.colorbox-min.js"></script>	
<link rel="stylesheet" href="/static/colorbox/colorbox.css" />
<script type="text/javascript">

jQuery(function($) {
	var colorbox_params = {
		reposition:true,
		scalePhotos:true,
		scrolling:false,
		previous:'<i class="icon-arrow-left"></i>',
		next:'<i class="icon-arrow-right"></i>',
		close:'&times;',
		current:'{current} of {total}',
		maxWidth:'100%',
		maxHeight:'100%',
		onOpen:function(){
			document.body.style.overflow = 'hidden';
		},
		onClosed:function(){
			document.body.style.overflow = 'auto';
		},
		onComplete:function(){
			$.colorbox.resize();
		}
	};
	$('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
});
  </script>  

    <ul class="ace-thumbnails">
		<li>
			<a href="/static/image/image-1.jpg"  title="Photo Title" class="cboxElement" data-rel="colorbox">
				<img alt="150x150" src="/static/image/thumb-1.jpg"/>
			</a>
		</li>
	</ul>


