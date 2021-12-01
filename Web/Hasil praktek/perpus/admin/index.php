	<?php 
	session_start();
	if($_SESSION['status']!="login"){
		header("location:../login.php?pesan=belum_login");
	}
	?>
 
	<?php echo $_SESSION['username']; ?>! anda telah login.</h4>
	
	<br><br>
	<a href='logout.php'>Lokot</a>
 
	