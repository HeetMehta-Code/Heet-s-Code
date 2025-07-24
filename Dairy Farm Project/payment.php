<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "gaushala_db";

    $conn = new mysqli($servername, $username, $password, $dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $full_name   = $conn->real_escape_string($_POST['firstname']);
    $email       = $conn->real_escape_string($_POST['email']);
    $address     = $conn->real_escape_string($_POST['address']);
    $city        = $conn->real_escape_string($_POST['city']);
    $state       = $conn->real_escape_string($_POST['state']);
    $zip         = $conn->real_escape_string($_POST['zip']);
    $card_name   = $conn->real_escape_string($_POST['cardname']);
    $card_number = $conn->real_escape_string($_POST['cardnumber']);
    $exp_month   = $conn->real_escape_string($_POST['expmonth']);
    $exp_year    = $conn->real_escape_string($_POST['expyear']);
    $cvv         = $conn->real_escape_string($_POST['cvv']);

    $sql = "INSERT INTO payments (
      full_name, email, address, city, state, zip,
      card_name, card_number, exp_month, exp_year, cvv
    ) VALUES (
      '$full_name', '$email', '$address', '$city', '$state', '$zip',
      '$card_name', '$card_number', '$exp_month', '$exp_year', '$cvv'
    )";

    if ($conn->query($sql) === TRUE) {
        $message = "✅ Payment saved successfully!";
    } else {
        $message = "❌ Error: " . $conn->error;
    }

    $conn->close();
}
?>

<html>
<head>
  <title>HKGG</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="p-styles.css">
</head>
<body>
<nav id="navbar">
	<div class="logo">
	<h1>Hare Krishna Gir Gaushala</h1>
	</div>
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>
        <ul id="linkk">
	      <b/>
            <li class="item"><a href="index.html">Home</a></li>
            <li class="item"><a href="login.php">Login</a></li>
            <li class="item"><a href="address.php">Address</a></li>
            <li class="item"><a href="contact.php">Contact Us</a></li>
            <li class="item"><a href="about.html">About Us</a></li>
        </ul>
    </nav>
    <?php if (!empty($message)) echo "<h3>$message</h3>"; ?>
  <h1>Payment</h1>
  <div class="row">
    <div class="col-75">
      <div class="container">
        <form action="" method="POST">
          <div class="row">
            <div class="col-50">
              <h3>Billing Address</h3>
              <label for="fname"><i class="fa fa-user"></i> Full Name</label>
              <input type="text" id="fname" name="firstname" placeholder="Heet Mehta">

              <label for="email"><i class="fa fa-envelope"></i> Email</label>
              <input type="text" id="email" name="email" placeholder="abc@example.com">

              <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
              <input type="text" id="adr" name="address" placeholder="Area">

              <label for="city"><i class="fa fa-institution"></i> City</label>
              <input type="text" id="city" name="city" placeholder="Gandhinagar">

              <div class="row">
                <div class="col-50">
                  <label for="state">State</label>
                  <input type="text" id="state" name="state" placeholder="Gujarat">
                </div>
                <div class="col-50">
                  <label for="zip">Zip</label>
                  <input type="text" id="zip" name="zip" placeholder="382007">
                </div>
              </div>
            </div>

            <div class="col-50">
              <h3>Payment</h3>
              <label for="fname">Accepted Cards</label>
              <div class="icon-container">
                <i class="fa fa-cc-visa" style="color:navy;"></i>
                <i class="fa fa-cc-amex" style="color:blue;"></i>
                <i class="fa fa-cc-mastercard" style="color:red;"></i>
                <i class="fa fa-cc-discover" style="color:orange;"></i>
              </div>

              <label for="cname">Name on Card</label>
              <input type="text" id="cname" name="cardname" placeholder="Heet Mehta">

              <label for="ccnum">Credit card number</label>
              <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">

              <label for="expmonth">Exp Month</label>
              <input type="text" id="expmonth" name="expmonth" placeholder="September">

              <div class="row">
                <div class="col-50">
                  <label for="expyear">Exp Year</label>
                  <input type="text" id="expyear" name="expyear" placeholder="2030">
                </div>
                <div class="col-50">
                  <label for="cvv">CVV</label>
                  <input type="text" id="cvv" name="cvv" placeholder="352">
                </div>
              </div>
            </div>
          </div>

          <label>
            <input type="checkbox" checked="checked" name="sameadr"> Shipping Address same as Billing
          </label>
          <input type="submit" value="Continue to Payment" class="btn">
        </form>
      </div>
    </div>
  </div>

</body>
</html>