<!DOCTYPE html>
<html>
<head>
    <title>HKGG</title>
    <link rel="stylesheet" href="aa-styles.css">
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
    <h1>Delivery Address</h1>
    <hr>    

    <form method="POST" action="address.php">
        <p>
            <select name="city" required>
                <option value="">-- Select City --</option>
                <option value="Gandhinagar">Gandhinagar</option>
                <option value="Ahmedabad">Ahmedabad</option>
                <option value="Surat">Surat</option>
                <option value="Vadodara">Vadodara</option>
                <option value="Bharuch">Bharuch</option>
                <option value="Amreli">Amreli</option>
                <option value="Kuch">Kuch</option>
                <option value="Mumbai">Mumbai</option>
                <option value="Vapi">Vapi</option>
                <option value="Rajkot">Rajkot</option>
            </select>
        </p>

        <p>
            <input type="text" name="pincode" placeholder="Pin Code" required>
        </p>

        <p>
            <input type="text" name="address" placeholder="Enter Your Full Address" required>
        </p>

        <p>
            <input type="text" name="society_name" placeholder="Society Name" required>
        </p>

        <p>
            <input type="text" name="house_number" placeholder="House/Flat Number" required>
        </p>

        <p>
            <input type="text" name="block" placeholder="Block" required>
        </p>

        <p>
            <input type="submit" value="Save Address">
        </p>
    </form>
</div>

</body>
</html>
