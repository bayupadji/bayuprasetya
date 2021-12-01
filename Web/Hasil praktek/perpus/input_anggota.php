<html>
<head>
<link rel='stylesheet' href='css/style.css'>
<style type="text/css">
<!--
.style1 {font-family: "Back to Black Bold Demo"}
.style2 {color: #FFFFFF}
.style7 {font-family: Calibri}
.style9 {font-family: Calibri; color: #000000; font-weight: bold; }
.style10 {color: #000000}
-->
</style>
</head>
<body>
<center>
     <h1 class="style1 style2">Selamat Datang Di Perpustakaan</h1>
     </center>
     <br>
<td width="500">
      <form method="post" action="proses.php" >
      
    <table width="500" height="220" border="0" align="center" id='w'>
      <tr>
        <td width="148"><span class="style9">Nama</span></td>
        <td width="10">:</td>
        <td width="328"><input name="nama" type="text"  placeholder="Nama"></td>
      </tr>
        
      <tr>
        <td><span class="style9">TTL</span></td>
        <td>:</td>
        <td><span class="style7">
          <textarea name="ttl" placeholder="Tempat tanggal lahir" ></textarea>
        </span></td>
      </tr>
      <tr>
        <td><span class="style9">Alamat</span></td>
        <td>:</td>
        <td><span class="style7">
            <textarea name="alamat" placeholder="Alamat" ></textarea>
          
        </span></td>
      </tr>
      <tr>
        
        
        <td><input name="simpan" type="submit" class="kl" value="simpan"></td>
      </tr>
    </table>
    <br/>
          

    </form>    
    </td>
    </tr>
  </table>

</body>
</html>