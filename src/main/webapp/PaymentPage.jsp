<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Proceed to Pay 199 Rs?</h1>
<button id="rzp-button1">Pay</button>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
var options = {
    "key": "${details.keyDetails}", // Enter the Key ID generated from the Dashboard
    "amount": "${details.amount}", // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "INR",
    "name": "Job-Portal", //your business name
    "description": "For Purchasing prime membership",
    "image": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fexternlabs.com%2Fblogs%2Fjob-portal-app-development%2F&psig=AOvVaw2CCNDtfteDyYSvGGqDGCLJ&ust=1699612761689000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCNj-h4vdtoIDFQAAAAAdAAAAABAD",
    "order_id": "${details.orderId}", //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
    "callback_url": "https://fictional-garbanzo-qjvjppwg9qqh95jp-8080.app.github.dev/user/payment/${details.id}",
    "prefill": { //We recommend using the prefill parameter to auto-fill customer's contact information especially their phone number
        "name": "${user.name}", //your customer's name
        "email": "${user.email}",
        "contact": "+91${user.mobile}" //Provide the customer's phone number for better conversion rates 
    },
    "notes": {
        "address": "Razorpay Corporate Office"
    },
    "theme": {
        "color": "#F3B664"
    }
};
var rzp1 = new Razorpay(options);
document.getElementById('rzp-button1').onclick = function(e){
    rzp1.open();
    e.preventDefault();
}
</script>
</body>
</html>