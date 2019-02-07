$(function() {
	// Solving the active menu problem
	switch (menu) {
	case 'About Us':
		// #about is a jQuery selector
		$('#about').addclass('active');
		break;
	case 'Contact Us':
		$('#contact').addclass('active');
		break;
	case 'All Products':
		$('#listProducts').addclass('active');
		break;
	default:
		$('#listProducts').addclass('active');
		$('#a_'+menu).addclass('active');
		break;
	}

});