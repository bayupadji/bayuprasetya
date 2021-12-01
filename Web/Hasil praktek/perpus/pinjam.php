<html>
<head>
<link rel='stylesheet' href='css/style.css'>
<style type="text/css">
<!--
  .style1 {color: #FFFFFF}
  .style6 {
  	color: #00FF00;
  	font-size: 18px;
  }
-->
</style>
</head>
<body>
<center>
  <h1 class="style1">Sistem Informasi Perpustakaan</h1>
  </td>
</center>
    
    <ul>
    <li><a href="index.php">Home</a></li>
    <li><a href="anggota.php">Anggota</a></li>
    <li><a href="buku.php">Buku</a></li>
    <li><a href="pinjam.php">Pinjam</a></li>
	<li style="float:right"><a class="active" href="admin/logout.php">keluar</a></li>
    <li style="float:right"><a class="active" href="pinjam_buku.php">Pinjam Buku</a></li>
    </ul>      
   
    <td width="500">
      
      <p align="center" class="style6">Buku yang sedang dipinjam  </p>
     
      <table id="nm" border="0" >  
       <thead>    
         
         <tr>
           <th >No</th>
              <th >Tanggal Pinjam Buku </th>
              <th >Jumlah Pinjam </th>
              <th >tanggal kembali </th>
              <th >nama peminjam</th>
              <th >Buku</th>
                
            <th >Aksi</th>
            </tr>
         </thead>
       
       
       
       <tbody>
         <?php 
include "koneksi.php";
$query    = "select * from meminjam,buku,anggota
where meminjam.id_anggota = anggota.id_anggota and
meminjam.kd_buku = buku.kd_buku and meminjam.kembali = 1
 order by id_pinjam";
$sql    = mysqli_query ($koneksi,$query);
$no = 1;
while ($data=mysqli_fetch_array($sql)) {
?>            
         <tr class="odd gradeX">
           <td><?php echo $no?></td>
                <td><?php echo $data['tgl_pinjam'];?></td>
                 <td><?php echo $data['jumlah_pinjam'];?></td>
                  <td><?php echo $data['tgl_kembali'];?></td>
                   <td><?php echo $data['nm_anggota'];?></td>
                    <td class="center"><?php echo $data['judul_buku'];?></td>
                                                
                <td class="center"><a href="edit_pinjam.php?id=<?php echo $data['id_pinjam']; ?>" > Edit </a> | <a href="kembali_buku.php?id=<?php echo $data['id_pinjam']; ?>" onClick = "return confirm('Apakah Anda ingin mengembalikan  <?php echo $data['judul_buku']; ?>?')"> Kembalikan </a></td>
              </tr>
         
         <?php $no++; }?>
         </tbody>
       </table>
                                  <br>
      
      <p align="center" class="style6">buku yang sudah di kembalikan  </p>
<table border="1" id="nm">
                                       <thead>    
                                         
                                         <tr>
                                           <th >No</th>
                <th >Tanggal Pinjam Buku </th>
                <th >Jumlah Pinjam </th>
                <th >tanggal kembali </th>
                <th >nama peminjam</th>
                <th >Buku</th>
                
            <th >Aksi</th>
              </tr>
                                     </thead>
                                       
                                       
                                       
                                      <tbody>
                                        <?php 
include "koneksi.php";
$query    = "select * from meminjam,buku,anggota
where meminjam.id_anggota = anggota.id_anggota and
meminjam.kd_buku = buku.kd_buku and meminjam.kembali = 2
 order by id_pinjam";
$sql    = mysqli_query ($koneksi,$query);
$no = 1;
while ($data=mysqli_fetch_array($sql)) {
?>            
                                         <tr class="odd gradeX">
                                           <td><?php echo $no?></td>
                                             <td><?php echo $data['tgl_pinjam'];?></td>
                                              <td><?php echo $data['jumlah_pinjam'];?></td>
                                               <td><?php echo $data['tgl_kembali'];?></td>
                                                <td><?php echo $data['nm_anggota'];?></td>
                                                 <td class="center"><?php echo $data['judul_buku'];?></td>
                                                
                                            <td class="center"><a href="hapus_pinjam.php?id=<?php echo $data['id_pinjam']; ?>" 
    onClick = "return confirm('Apakah Anda ingin mengapus  <?php echo $data['id_pinjam']; ?>?')"> hapus</a> </td>
                                          </tr>
                                         
                                         <?php $no++; }?>
                                      </tbody>
                                  </table>    </td>
</tr>
  </table>
</div>
</body>
</html>