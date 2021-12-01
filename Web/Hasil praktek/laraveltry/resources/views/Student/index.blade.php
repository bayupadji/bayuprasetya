@extends('layout.main')

@section('title','Student')

@section('container')
    <div class="container">
        <div style="margin-top:3em;">
            <h3 class="p-2 flex-grow-1">DATA MAHASISWA</h3>

            <ul class="list-group">
                @foreach ( $data as $dt )
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    {{$dt -> nama_mhs}}
                    <a href="/Student/{{ $dt->id }}" class="badge badge-info">DETAIL</a>
                </li>

                @endforeach

            </ul>

        </div>
    </div>
@endsection
