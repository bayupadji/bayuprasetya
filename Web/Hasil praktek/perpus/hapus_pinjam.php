<?php 
// koneksi database
include 'koneksi.php';

$id = $_GET['id_pinjam'];
 
// menghapus data dari database
mysqli_query($koneksi,"delete from mahasiswa where id='$id'");
 
header("location:pinjam.php");
    
?>