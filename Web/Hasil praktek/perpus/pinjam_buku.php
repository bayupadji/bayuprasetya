<html>
<head>
<link rel="stylesheet" href="css/style.css">
<style type="text/css">
<!--
.style1 {
	font-family: "Back to Black Bold Demo";
	color: #FFFFFF;
}
-->
</style>
</head>
<body>
<center>
  <h1 class="style1"> Perpustakaan Cerdas</h1>
  </td>
</center>
    
        <ul>
        <li><a href="anggota.php">Anggota</a></li>
    <li><a href="buku.php">Buku</a></li>
    <li><a href="pinjam.php">Pinjam</a></li>
    </ul>
  
    <td width="500">
      <?php include "koneksi.php";?>
      <form method="post" action="proses_pinjam.php" >
        <table border="0" align="center" id="w" width="40%">
          <tr>
            <td>Nama Peminjam</td>
    <td>:</td>
    <td><?php

$sql_anggota="select * from anggota order by id_anggota";
$kueri_anggota=mysqli_query($koneksi,$sql_anggota) or die(mysql_error());
?>
      <select name="anggota">
        <?php
 while (list($kode,$nama_status)=mysqli_fetch_array($kueri_anggota))
   {
?>
        <option  value="<?php echo $kode ?>"><?php echo $nama_status ?></option>
        <?php
  }
?>
        </select></td>
    </tr>
          <tr>
            <td>Judul Buku </td>
    <td>:</td>
    <td><?php

$sql_buku="select * from buku order by kd_buku";
$kueri_buku=mysqli_query($koneksi,$sql_buku) or die(mysql_error());
?>
      <select name="buku">
        <?php
 while (list($kode,$nama_status)=mysqli_fetch_array($kueri_buku))
   {
?>
        <option  value="<?php echo $kode ?>"><?php echo $nama_status ?></option>
        <?php
  }
?>
        </select><td>
          </tr>                                            
          
          
          <tr>
            <td></td>
    <td></td>
    <td><input type="submit" name="simpan" value="simpan"></td>
    </tr>
          </table>
    </form>    </td>
    </tr>
  </table>
</div>
</body>
</html>
