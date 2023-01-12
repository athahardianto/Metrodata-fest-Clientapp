window.onscroll = function() {myFunction()};

// Get the navbar
var navbar = document.getElementById("navbar");

// Get the offset position of the navbar
var sticky = navbar.offsetTop;

// Add the sticky class to the navbar when you reach its scroll position. Remove "sticky" when you leave the scroll position
function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}

var date = new Date();
var current_date = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+ date.getDate();
document.getElementById("orderDate").innerHTML=current_date;
var current_time = date.getHours()+":"+date.getMinutes()+":"+ date.getSeconds();
	document.getElementById("orderDate").innerHTML = current_time;

$(".form-control").chosen({
  width:"20",
  height:"20"
})

jQuery().ready(function() { /* Custom select design */ jQuery('.drop-down').append('<div class="button"></div>'); jQuery('.drop-down').append('<ul class="select-list"></ul>'); jQuery('.drop-down select option').each(function() { var bg = jQuery(this).css('background-image'); jQuery('.select-list').append('<li class="clsAnchor"><span value="' + jQuery(this).val() + '" class="' + jQuery(this).attr('class') + '" style=background-image:' + bg + '>' + jQuery(this).text() + '</span></li>'); }); jQuery('.drop-down .button').html('<span style=background-image:' + jQuery('.drop-down select').find(':selected').css('background-image') + '>' + jQuery('.drop-down select').find(':selected').text() + '</span>' + '<a href="javascript:void(0);" class="select-list-link">Arrow</a>'); jQuery('.drop-down ul li').each(function() { if (jQuery(this).find('span').text() == jQuery('.drop-down select').find(':selected').text()) { jQuery(this).addClass('active'); } }); jQuery('.drop-down .select-list span').on('click', function() { var dd_text = jQuery(this).text(); var dd_img = jQuery(this).css('background-image'); var dd_val = jQuery(this).attr('value'); jQuery('.drop-down .button').html('<span style=background-image:' + dd_img + '>' + dd_text + '</span>' + '<a href="javascript:void(0);" class="select-list-link">Arrow</a>'); jQuery('.drop-down .select-list span').parent().removeClass('active'); jQuery(this).parent().addClass('active'); $('.drop-down select[name=options]').val( dd_val ); $('.drop-down .select-list li').slideUp(); }); jQuery('.drop-down .button').on('click','a.select-list-link', function() { jQuery('.drop-down ul li').slideToggle(); }); /* End */ });