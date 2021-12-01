@extends('layout.main')

@section('title','Detail')

@section('container')
    <div class="container">
        <div class="card" style="margin-top:3em;">
            <div class="card-body">
                <h5 class="card-title">{{$student -> nama_mhs}}</h5>
                <h6 class="card-subtitle mb-2 text-muted">{{$student -> nim}}</h6>
                <p class="card-text">Mata Kuliah : {{$student -> matakuliah}}</p>
                <p class="card-text">Nilai : {{$student -> nilai_huruf}}</p>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
        </div>
    </div>
@endsection
