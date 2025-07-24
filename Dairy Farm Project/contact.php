<?php
$message = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name    = $_POST['name'];
    $email   = $_POST['email'];
    $subject = $_POST['subject'];
    $msg     = $_POST['message'];

    $conn = new mysqli("localhost", "root", "", "gaushala_db");

    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $stmt = $conn->prepare("INSERT INTO contact_messages (name, email, subject, message) VALUES (?, ?, ?, ?)");
    $stmt->bind_param("ssss", $name, $email, $subject, $msg);

    if ($stmt->execute()) {
        $message = "Message sent successfully!";
    } else {
        $message = "Error: " . $stmt->error;
    }

    $stmt->close();
    $conn->close();
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>HKGG</title>
    <link rel="stylesheet" href="c-styles.css">
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
<div class="main-content">
    <div class="container">
        <h1 class="contact">Contact Form</h1>
        <?php if (!empty($message)) echo "<p style='color:green; font-weight:bold;'>$message</p>"; ?>
        <form method="POST" action="">
            <p class="bold" style="font-size: 20px; line-height: 30px;">
                Your Name:<br>
                <input type="text" name="name" required placeholder="Your full name">
            </p>
            <p class="bold" style="font-size: 20px; line-height: 30px;">
                Your Email:<br>
                <input type="email" name="email" required placeholder="Enter valid email address">
            </p>
            <p class="bold" style="font-size: 20px; line-height: 30px;">
                Message:<br>
                <textarea name="message" cols="100" rows="3" required></textarea>
            </p>
            <p class="bold" style="font-size: 20px; line-height: 30px;">
                Subject:<br>
                <input type="text" name="subject" required>
            </p>
            <br>
            <input type="submit" value="Send" class="bold" style="font-size: 20px;">
        </form>
    </div>

    <div class="map-container">
        <iframe
            src="https://www.google.com/maps/"
            allowfullscreen=""
            loading="lazy"
            referrerpolicy="no-referrer-when-downgrade">
        </iframe>
    </div>
</div>
</body>
</html>
