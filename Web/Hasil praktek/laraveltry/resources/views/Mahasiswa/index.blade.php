@extends('layout.main')

@section('title','Mahasiswa')

@section('container')
    <div class="container">
        <div class="card shadow-sm p-3 mb-5 bg-white rounded" style="margin-top:3em;">
                <!--header card-->
                <div class="card-header">
                <h3>DATA MAHASISWA</h3>
                </div>

                <!--body card-->
                <div class="card-body">
                    <a href="/Mahasiswa/create" class="btn btn-info mr-auto p-2 my-2" >+Tambahkan Data</a>
                    <!--table-->
                    <table class="table">
                        <thead class="table-dark ">
                            <th scope="col">No</th>
                            <th scope="col">Nim</th>
                            <th scope="col">Nama Mahasiswa</th>
                            <th scope="col">Mata Kuliah</th>
                            <th scope="col">Nilai Angka</th>
                            <th scope="col">Nilai Huruf</th>
                            <th scope="col">Nilai Predikat</th>
                        </thead>

                        <tbody class="table-light">
                            @foreach ($data as $dt)
                                <tr>
                                    <td>{{ $loop -> iteration }}</td>
                                    <td>{{ $dt -> nim }}</td>
                                    <td>{{ $dt -> nama_mhs }}</td>
                                    <td>{{ $dt -> matakuliah }}</td>
                                    <td>{{ $dt -> nilai_angka }}</td>
                                    <td>{{ $dt -> nilai_huruf }}</td>
                                    <td>{{ $dt -> predikat }}</td>
                                </tr>
                            @endforeach
                        </tbody>
                    </table>
                </div>

                <!--footer card-->
                <div class="card-footer">
                    <small> A11.2019.11688 - Bayu Prasetya Adji Sugiyarto</small>
                </div>
        </div>
    </div>


@endsection
