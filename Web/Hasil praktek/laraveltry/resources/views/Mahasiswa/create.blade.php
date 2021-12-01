
@extends('layout.main')

@section('title','Tambah Data Mahasiswa')

@section('container')
	<form class="px-4 py-3" method="post" action="/Mahasiswas/create">
		<div class="form-group">
			<label for="exampleInputEmail1">nim</label>
			<input type="int" class="form-control" aria-describedby="emailHelp" name="nim" placeholder="Masukan Kode">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Nama Mahasiswa</label>
			<input type="text" class="form-control" aria-describedby="emailHelp" name="nama_mhs" placeholder="Masukan Nama Barang">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Mata kuliah</label>
			<input type="text" class="form-control" aria-describedby="emailHelp" name="matakuliah" placeholder="Masukan Harga">
		</div>
        <div class="form-group">
			<label for="exampleInputEmail1">Nilai Angka</label>
			<input type="text" class="form-control" aria-describedby="emailHelp" name="nilai_angka" placeholder="Masukan Harga">
		</div>
        <div class="form-group">
			<label for="exampleInputEmail1">Nilai Huruf</label>
			<input type="text" class="form-control" aria-describedby="emailHelp" name="nilai_huruf" placeholder="Masukan Harga">
		</div>
        <div class="form-group">
			<label for="exampleInputEmail1">Predikat</label>
			<input type="text" class="form-control" aria-describedby="emailHelp" name="predikat" placeholder="Masukan Harga">
		</div>
	<button type="submit" class="btn btn-info">Masukan</button>
	</form>
@endsection
