<?php
session_start();
$message = "";

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "gaushala_db";

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST['login'])) {
        $input_username = $conn->real_escape_string($_POST['username']);
        $input_password = $conn->real_escape_string($_POST['password']);

        $sql = "SELECT * FROM users WHERE username='$input_username' AND password='$input_password'";
        $result = $conn->query($sql);

        if ($result->num_rows === 1) {
            $_SESSION['username'] = $input_username;
            $message = "Login successful! Welcome, $input_username.";
        } else {
            $message = "Invalid username or password.";
        }
    } elseif (isset($_POST['register'])) {
        $new_username = $conn->real_escape_string($_POST['new_username']);
        $new_password = $conn->real_escape_string($_POST['new_password']);

        $check_user = "SELECT * FROM users WHERE username='$new_username'";
        $user_result = $conn->query($check_user);

        if ($user_result->num_rows > 0) {
            $message = "Username already exists. Please choose another.";
        } else {
            $insert_sql = "INSERT INTO users (username, password) VALUES ('$new_username', '$new_password')";
            if ($conn->query($insert_sql) === TRUE) {
                $message = "Registration successful! You can now login.";
            } else {
                $message = "Error: " . $conn->error;
            }
        }
    }
}

$conn->close();
?>
<!DOCTYPE html>
<html>

<head>
  <title>HKGG</title>
  <link rel="stylesheet" href="l-style.css">
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
  <div class="container">
  <?php if (!empty($message)) echo "<h3 style='color:green;'>$message</h3>"; ?>

  <div class="tab">
    <button class="btn" onclick="showForm('loginForm')">Login</button>
    <button class="btn" onclick="showForm('registerForm')">Register</button>
  </div>

  <div class="row">
    <div class="col">
      <a href="#" class="fb btn"><i class="fa fa-facebook fa-fw"></i> Login with Facebook</a>
      <a href="#" class="twitter btn"><i class="fa fa-twitter fa-fw"></i> Login with Twitter</a>
      <a href="#" class="google btn"><i class="fa fa-google fa-fw"></i> Login with Google</a>
    </div>

    <div class="col">
      <div class="hide-md-lg">
        <p>Or Sign in manually:</p>
      </div>

      <form id="loginForm" method="POST">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="submit" name="login" value="Login">
      </form>

      <form id="registerForm" method="POST" style="display:none;">
        <input type="text" name="new_username" placeholder="New Username" required>
        <input type="password" name="new_password" placeholder="New Password" required>
        <input type="submit" name="register" value="Register">
      </form>

      <br>
      <a href="#" class="signup-btn">Forgot password?</a>
    </div>
  </div>
</div>

<script>
function showForm(formId) {
  document.getElementById('loginForm').style.display = 'none';
  document.getElementById('registerForm').style.display = 'none';
  document.getElementById(formId).style.display = 'block';
}

showForm('loginForm');
</script>

</body>
</html>