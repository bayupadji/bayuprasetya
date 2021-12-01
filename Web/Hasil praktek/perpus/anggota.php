<html>
<head>
<link rel='stylesheet' href='css/style.css'>
<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
</style>
</head>
<body>
<center class="style1">
  <h1>Sistem Informasi Perpustakaan</h1>
  </center>
<ul>
    <li><a href="index.php">Home</a></li>
    <li><a href="anggota.php">Anggota</a></li>
    <li><a href="buku.php">Buku</a></li>
    <li><a href="pinjam.php">Pinjam</a></li>
    <li style="float:right"><a class="active" href="admin/logout.php">keluar</a></li>
    <li style="float:right"><a class="active" href="input_anggota.php">Daftar</a></li>
    <li style="float:right"><a class="active" href="pinjam_buku.php">Pinjam Buku</a></li>
    </ul>
    <br>
      <table id='nm' border="1" >
        <thead>   
          
          <tr>
            <th >No</th>
              <th >Id anggota </th>
              <th >Nama Anggota </th>
              <th >alamat </th>
              <th >TTl </th>
              <th > </th>           
             </tr>
        </thead>
        
        
        
        <tbody>
          <?php 
include "koneksi.php";
$query    = "select * from anggota order by id_anggota";
$sql    = mysqli_query ($koneksi,$query);
$no = 1;
while ($data=mysqli_fetch_array($sql)) {
?>           
          <tr class="odd gradeX">
            <td><?php echo $no?></td>
                <td><?php echo $data['id_anggota'];?></td>
                <td><?php echo $data['nm_anggota'];?></td>
                <td><?php echo $data['alamat'];?></td>
                <td><?php echo $data['ttl_anggota'];?></td>
                <td class="center"><?php echo $data['status_anggota'];?></td>
                                               
                
          
          <?php $no++; }?>
        </tbody>
</table>    </td>
    </tr>
  </table>
</div>
</body>
</html>