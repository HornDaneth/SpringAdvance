var tree = {
	init: function(){
		tree.requestData(tree.successHandler, tree.failHandler)
	},
	
	
	constructTreeDOM: function( treeData ) {
		var htmlText = '';
		/*getting root element*/
		htmlText += '<li>';
		htmlText += '<span class="folder" href="#">' + treeData.departmentName + '</span>' ;
		
		/*getting sub elements*/
		if( treeData.leaf != true ) {
			htmlText += "<ul>";
			$.each( treeData.userChildren, function(index, value){
				htmlText += '<li><span class="file" id="' + value.userName + '" href="#">' + value.fullName + '</span></li>';
			});
			$.each( treeData.departmentChildren, function(index, value){
				htmlText +=  tree.constructTreeDOM( value ) ;
			});
			htmlText += "</ul>";
		}
		
		htmlText += '</li>';
		return htmlText;
	},
	
	requestData: function(successHandler, failHandler){
		var url = "../tree";
		var method = "GET";
		var responseType = "json";
		$.ajax({
			type: method,
			url: url ,
		    contentType: "application/json",
			dataType:responseType,
			success: function(data){
				successHandler(data);
				
			},
			error:function (error){
				failHandler();
			}    
		});
	},
	
	successHandler: function( data ) {
		var htmlText = tree.constructTreeDOM(data);
		$("#browser").append(  htmlText );
		
		// first example
		$("#browser").treeview({
			collapsed: true,
			animated: "fast"
		}).delegate("span[class=file]", "click", function ( events ) { 
			alert( "Login Name:" + $(this).attr("id") + ", Full Name:" +  $(this).text() );
		});
	},
	
	failHandler: function(error) {
		alert("OOPS!")
	}
};


$(document).ready(function(){
	tree.init();
		// second example
	/*	$("#navigation").treeview({
			persist: "location",
			collapsed: true,
			unique: true
		});*/
		
		// third example
	/*	$("#red").treeview({
			animated: "fast",
			collapsed: true,
			unique: true,
			persist: "cookie",
			toggle: function() {
				window.console && console.log("%o was toggled", this);
			}
		});*/
		
		// fourth example
	/*	$("#black, #gray").treeview({
			control: "#treecontrol",
			persist: "cookie",
			cookieId: "treeview-black"
		});*/

});