<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}/"/>
<style>
/* 메인 슬라이드 Slideshow container */ /* Slideshow container */
* {
	box-sizing: border-box
}

body {
	font-family: Verdana, sans-serif;
	margin: 0
}
/* Slideshow container */
.slideshow-container {
	text-align: center;
	width: 1280px;
	height: 100px;
	position: absolute;
    left: 50%;
    top: 21%;
    transform: translate(-50%, -50%);
	margin-top: 5px;
	
	border-bottom: 0.3px solid #000;
}

.main_slideImg {
	width: 100%;
	height: 300px;
	object-fit: cover;
	
	
	/* top: 100px; */
}

/* Next & previous buttons */
.prev, .next {
	cursor: pointer;
	position: absolute;
	text-align: center;
	top: 0;
	top: 150%;
	width: 3%;
	padding: 16px;
	margin-top: -22px;
	color: white;
	font-weight: bold;
	font-size: 18px;
	transition: 0.5s ease;
	border-radius: 0 4px 4px 0;
	z-index: 100;
}
/* Position the "next button" to the right */
.prev {
	left: 0;
	border-radius: 0 4px 4px 0;
}
.next {
	right: 0;
	border-radius: 0 4px 4px 0;
}
/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
	background-color: rgba(0, 0, 0, 0.8);
}

/* Number text (1/3 etc) */
.numbertext {
	color: #f2f2f2;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}

.dots{
	display: absolute;
	top: 100%;
	margin-top: 170px;
	height: 13px;
}
/* The dots/bullets/indicators */
.dot {
	cursor: pointer;
	height: 13px;
	width: 13px;
	margin: 0 2px;
	background-color: #bbb;
	border-radius: 50%;
	display: inline-block;
	transition: background-color 0.6s ease;
}

.active, .dot:hover {
	background-color: #717171;
}
/* Fading animation */
.fade2 {
	-webkit-animation-name: fade;
	-webkit-animation-duration: 0.5s;
	animation-name: fade;
	animation-duration: 5s;
}

@-webkit-keyframes fade2 {

	from {opacity:.4}
	to {opacity: 1}

}

@keyframes fade2 { 

	from {opacity:.4}
	to {opacity: 1}
}


}
/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
	  .slprev, .slnext, .text {font-size: 11px}
}
/* 
img {
	width: 100%;
	height: 100%;
	object-fit: cover;
}
 */
</style>
<body>

	<!-- 메인 슬라이드 -->
	<div class="slideshow-container">
		<div class="mySlides fade2">
			<img class="main_slideImg" src="${path}resources/img/adver1.png">
		</div>
		<div class="mySlides fade2">
			<img class="main_slideImg" src="${path}resources/img/adver2.png">
		</div>
		<div class="mySlides fade2">
			<img class="main_slideImg" src="${path}resources/img/adver3.png">
		</div>
		<a class="prev" onclick="plusSlides(-1)">❮</a>
		<a class="next" onclick="plusSlides(1)">❯</a>
	</div>
	<br>
	<!-- 
	<div style="text-align: center" class="dots">
		<span class="dot" onclick="currentSlide(1)"></span>
		<span class="dot" onclick="currentSlide(2)"></span>
		<span class="dot" onclick="currentSlide(3)"></span>
	</div> -->
	<!-- 메인 슬라이드 End -->

</body>	

<script>

	//슬라이드 스크립
	var slideIndex = 1;
	showSlides(slideIndex);
	
	function plusSlides(n) {
		showSlides(slideIndex += n);
	}
	function currentSlide(n) {
		showSlides(slideIndex = n);
	}
	function showSlides(n) {
		var i;
		var slides = document.getElementsByClassName("mySlides");
		var dots = document.getElementsByClassName("dot");
		if (n > slides.length) {
			slideIndex = 1
		}
		if (n < 1) {
			slideIndex = slides.length
		}
		for (i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";
		}
		for (i = 0; i < dots.length; i++) {
			dots[i].className = dots[i].className.replace(" active", "");
		}
		slides[slideIndex - 1].style.display = "block";
		dots[slideIndex - 1].className += " active";
		slideIndex++;
		if (slideIndex > slides.length) { // 마지막 슬라이드에서 다음 슬라이드로 이동
			slideIndex = 1;
		}
		setTimeout(showSlides, 5000); // 3초마다 자동 전환
	}
	
</script>