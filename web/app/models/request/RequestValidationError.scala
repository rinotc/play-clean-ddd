package models.request

class RequestValidationError(val message: String) extends Exception(message)
