var source = $("#gallery_item").html();

var template = Handlebars.compile(source);

var data = {
		items:[
			{
				src:"img/1.jpg",
				title:"title",
				writer:"writer"
			},
			{
				src:"img/2.jpg",
				title:"title",
				writer:"writer"
			},
			{
				src:"img/3.jpg",
				title:"title",
				writer:"writer"
			},
			{
				src:"img/4.jpg",
				title:"title",
				writer:"writer"
			},
			
		]
};

var html = template(data);

$("#gallery_container").append(html);