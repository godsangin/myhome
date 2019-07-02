/**
 * 
 */

var products = [
	{
		"title":'Moara',
		"content":'Moara: 종이쿠폰을 대체할 차세대 모바일 쿠폰 애플리케이션<br/>전세계 500만 가맹점을 가진 강력한 쿠폰관리 애플리케이션',
		"src":'/img/moara.PNG'
	},
	{
		"title":'MyDays',
		"content":'전국민이 사용한다는 일정 관리 애플리케이션<br/>시간단위로 나뉜 본인만의 일정을 입맛대로 관리할 수 있다',
		"src":'/img/mydays.PNG'
	},
	{
		"title":'API Service',
		"content":'전국민이 사용한다는 일정 관리 애플리케이션<br/>시간단위로 나뉜 본인만의 일정을 입맛대로 관리할 수 있다',
		"src":'/img/moara.PNG'
	},
	{
		"title":'MyHome',
		"content":'전국민이 사용한다는 일정 관리 애플리케이션<br/>시간단위로 나뉜 본인만의 일정을 입맛대로 관리할 수 있다',
		"src":'/img/mydays.PNG'
	},
	{
		"title":'atc',
		"content":'전국민이 사용한다는 일정 관리 애플리케이션<br/>시간단위로 나뉜 본인만의 일정을 입맛대로 관리할 수 있다',
		"src":'/img/moara.PNG'
	}
];
$(document).ready(function(){
	$(".li-title").click(function(){
		_this = this;
		var item = products.filter(function(products) {
			return products.title == String(_this.innerHTML) });
		$("#product_img").attr("src", item[0].src);
		$("#product_content").html(item[0].content);
	});
});