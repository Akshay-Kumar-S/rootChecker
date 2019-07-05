package com.twoxmars.rootchecker

class RootCheckInfo {
    private var title : String
    private var content : String
    private var result : Boolean

    constructor(tv_title : String, tv_content : String, tv_result : Boolean) {
        title = tv_title
        content = tv_content
        result = tv_result
    }
}