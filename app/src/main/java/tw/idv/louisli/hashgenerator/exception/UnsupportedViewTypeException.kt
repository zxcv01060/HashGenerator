package tw.idv.louisli.hashgenerator.exception

class UnsupportedViewTypeException(viewType: Int) :
    IllegalArgumentException("不支援的viewType：$viewType")
