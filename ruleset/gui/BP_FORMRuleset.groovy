package gui

import pl.bpm4cloud.handler.InputHandler
import pl.bpm4cloud.handler.OnClickHandler

import groovy.time.*

class BP_FIELDSETHandler extends InputHandler {
  void onInit() {
    boolean newReq = !processStep
    BP_NAME.setReadOnly(!newReq)
    BP_EMAIL.setReadOnly(!newReq)
    BP_NUMOF.setReadOnly(!newReq)
    BP_DATE.setReadOnly(newReq)
    BP_HOUR.setReadOnly(!newReq)
    BP_INFO.setReadOnly(!newReq)
  }
}

class BP_EMAILHandler extends InputHandler {
  void onValidate() {
    String val = self.getValue()
    if (val) {
      def emailPattern = /[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})/
      if (!(val ==~ emailPattern)) {
        self.setRequiredValidation("Niepoprawny format adresu email")
      }
    }
    else {
      self.setRequiredValidation("Email jest wymagany") 
    }
    
  }
}

class BP_NUMOFHandler extends InputHandler {
  void onValidate() {
    String val = self.getValue()
    if (val) {
      def numOf = val as int
        if (numOf < 1 || numOf > 6) {
          self.setRequiredValidation("Liczba miejsc jest spoza zakresu 1-6")
        }
    }
    else {
      self.setRequiredValidation("Liczba rezerwowanych miejsc jest wymagana") 
    }
  }
}

class BP_DATEHandler extends InputHandler {
  void onInit() {
    def val = model?.getValue("ModelBP_FORM.BP_DATE")
    if (val) {
      self.setValue(val.format("yyyy-MM-dd")) 
    }
    else {
      def today = new Date()
      self.setValue(today.format("yyyy-MM-dd"))
      self.setReadOnly(false)  
    }
  }
  
  void onValidate() {
    String val = self.getValue()
    if (val) {
      def dateVal = Date.parse("yyyy-MM-dd", val)
      if (dateVal) {
        def today = new Date()
        today.clearTime()
        println "CURRENT DATA: $today, DATE VAL: $dateVal"
        if (dateVal < today) {
          self.setRequiredValidation("Niepoprawna wartość daty rezerwacji")
        }
        return
      }
    }
    self.setRequiredValidation("Data rezerwacji jest wymagana") 
  }
}

class BP_HOURHandler extends InputHandler {
  void onInit() {
    String val = model?.getValue("ModelBP_FORM.BP_HOUR")
    if (val) {
      //self.setValue(val.getAt(0..1) + ":" + val.getAt(2..3)) 
      self.setValue(val)
    }
    else {
      def today = new Date()
      use (TimeCategory) {
        today = today + 1.hour
      }
      self.setValue(today.format("HH:mm"))
    }
  }
}

class BP_RESPONSEHandler extends InputHandler {
  void onInit() {
    self.setVisible(false)
    if (processStep in ["VERIFY_REQ", "CONFIRM_OFFER"]) {
      self.setVisible(true) 
    }
    if (processStep in ["CONFIRM_OFFER"]) {
      self.setReadOnly(true)
    }
  }
}

class BP_SENDHandler extends OnClickHandler {
  void onInit() {
    if (!processStep || processStep == "CONFIRM_OFFER") {
      self.setVisible(true) 
    }
    else {
      self.setVisible(false) 
    }
  }
  
  void onAction() {
    if (guiScriptService.validateSection("BP_FORM")) {
      if (!processStep) {
        processScriptService.startProcess("BP_PROCESS", guiScriptService.readModelMap())
        //guiScriptService.saveSection("BP_FORM")
        guiScriptService.changeGui("BP_CONFIRM_REQ_FORM", true)
      }
      else if (processStep == "CONFIRM_OFFER") {
        processScriptService.executeTask("toSDEndState") 
      }
    }
  }
}

class BP_SEND_OFFERHandler extends OnClickHandler {
  void onInit() {
    if (processStep == "VERIFY_REQ") {
      self.setVisible(true) 
    }
    else {
      self.setVisible(false) 
    }
  }
  
  void onAction() {
    println("BP_RESPONSE ${BP_RESPONSE.getValue()}")
    model.setValue("ModelBP_FORM.BP_RESPONSE", BP_RESPONSE.getValue())
    processScriptService.executeTask("toSEND_OFFER")
  }
}

class BP_REJECT_OFFERHandler extends OnClickHandler {
  void onInit() {
    if (processStep == "VERIFY_REQ") {
      self.setVisible(true) 
    }
    else {
      self.setVisible(false) 
    }
  }
  
  void onAction() {
    model.setValue("ModelBP_FORM.BP_RESPONSE", BP_RESPONSE.getValue())
    processScriptService.executeTask("toREJECT_REQUEST")
  }
}
