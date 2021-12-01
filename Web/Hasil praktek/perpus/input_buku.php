<html>
<head>
<link rel="stylesheet" href="css/style.css">
<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
</style>
</head>
<body>
  <center>
     <h1 class="style1 style2 style1">Selamat Datang Di Perpustakaan</h1>
</center>
     <tr>
     <td >
        <ul>
    <li><a href="index.php">Home</a></li>
    <li><a href="anggota.php">Anggota</a></li>
    <li><a href="buku.php">Buku</a></li>
    <li><a href="pinjam.php">Pinjam</a></li>
</ul>   
    </td>
    </tr>  
    <td width="500">
      <form method="post" action="proses_buku.php" >
        <table border="0" align="center" id="w">
          <tr>
            <td>Kode Buku</td>
    <td>:</td>
    <td><input type="text" name="kode"  placeholder="Kode Buku"></td>
    </tr>
          <tr>
            <td>Judul Buku</td>
    <td>:</td>
    <td><input type="text" name="judul"  placeholder="Judul Buku"></td>
    </tr>
          <tr>
            <td>Pengarang</td>
    <td>:</td>
    <td><input type="text" name="pengarang"  placeholder="Pengarang Buku"></td>
    </tr>
          <tr>
            <td>Jenis Buku</td>
    <td>:</td>
    <td><input type="text" name="jenis"  placeholder="Jenis Buku">      </tr>
          <tr>
            <td>Penerbit Buku</td>
    <td>:</td>
    <td><input type="text" name="penerbit"  placeholder="Penerbit Buku">      </tr>
          <tr>
            <td> </td>
    <td></td>
    <td><input type="submit" name="simpan" value="simpan" class="kl"></td>
    </tr>
        </table>
    </form>    </td>
    </tr>
  </table>
</div>
</body>
</html>