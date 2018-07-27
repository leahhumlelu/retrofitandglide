package com.example.android.retrofitandglide.ViewModel;

import com.example.android.retrofitandglide.Retrofit.SearchResult;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class ApiResponse {
    public enum Status{
        LOADING,SUCCESS,ERROR,COMPLETED
    }
    public final Status status;
    @Nullable
    public final List<SearchResult> data;
    @Nullable
    public final Throwable error;

    public ApiResponse(Status status, @Nullable List<SearchResult> data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse loading(){
        return new ApiResponse(Status.LOADING,null,null);
    }

    public static ApiResponse success(@NonNull List<SearchResult> data){
        return new ApiResponse(Status.SUCCESS,data,null);
    }

    public static ApiResponse error(@NonNull Throwable error){
        return new ApiResponse(Status.ERROR,null,error);
    }
}