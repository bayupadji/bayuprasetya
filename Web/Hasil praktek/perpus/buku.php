<html>
<head>
<link rel='stylesheet' href='css/style.css'>
<style type="text/css">
<!--
.style2 {color: #FFFFFF}
-->
</style>
</head>
<body>
<center>
  <h1 class="style1 style2">Sistem Informasi Perpustakaan</h1></td>
</center>
    
    <ul>
    <li><a href="index.php">Home</a></li>
    <li><a href="anggota.php">Anggota</a></li>
    <li><a href="buku.php">Buku</a></li>
    <li><a href="pinjam.php">Pinjam</a></li>
    <li style="float:right"><a class="active" href="admin/logout.php">keluar</a></li>
    <li style="float:right"><a class="active" href="input_buku.php">Input Buku</a></li>
    </ul> 
    <br>     
   
            <table id="nm" border="0"  >
        <thead>    
          
          <tr>
            <th ><span class="style2">No</span></th>
              <th ><span class="style2">Kode Buku </span></th>
              <th ><span class="style2">Judul Buku </span></th>
              <th ><span class="style2">Pengarang </span></th>
              <th ><span class="style2">Jenis Buku</span></th>
              <th ><span class="style2">Penerbit</span></th>
                
            
          </tr>
        </thead>
        
        
        
        <tbody>
          <?php 
include "koneksi.php";
$query    = "select * from buku order by kd_buku";
$sql    = mysqli_query ($koneksi,$query);
$no = 1;
while ($data=mysqli_fetch_array($sql)) {
?>            
          <tr class="odd gradeX">
            <td><?php echo $no?></td>
                <td><?php echo $data['kd_buku'];?></td>
                 <td><?php echo $data['judul_buku'];?></td>
                  <td><?php echo $data['pengarang'];?></td>
                   <td><?php echo $data['jenis_buku'];?></td>
                    <td class="center"><?php echo $data['penerbit'];?></td>
                                                
                
          
          <?php $no++; }?>
        </tbody>
</table>    
            </td>
    </tr>
  </table>
  

</body>
</html>
