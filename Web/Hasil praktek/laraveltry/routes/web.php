<?php

use App\Http\Controllers\DataController;
use App\Http\Controllers\nilaiController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('main.index');
});


Route::get('/Mahasiswa/create', 'App\Http\Controllers\DataController@create');

Route::get('/Mahasiswa', 'App\Http\Controllers\DataController@index');

Route::post('/Mahasiswa', 'App\Http\Controllers\DataController@store');

Route::get('/Student', 'App\Http\Controllers\StudentsController@index');

Route::get('/Student/{student}', 'App\Http\Controllers\StudentsController@show');
