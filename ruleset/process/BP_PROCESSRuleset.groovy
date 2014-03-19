package process

import pl.bpm4cloud.script.ProcessScriptHandler

class ConfirmRequestHandler extends ProcessScriptHandler {
  String run() {
    String email = model.getValue("ModelBP_FORM.BP_EMAIL")
    if (email) {
      mail.sendMail([email] as String[], "Potwierdzenie zgłoszenia", """\
      <html>
      <body>
        <h1>Dziękujemy</h1>
        <p>Numer Twojego zgłoszenia: <strong>${processId}</strong></p>
      </body>
      </html>
      """)  
    }

    return "toVERIFY_REQ"
  }
}

class SendOfferHandler extends ProcessScriptHandler {
  String run() {
    String email = model.getValue("ModelBP_FORM.BP_EMAIL")
    if (email) {
      def date = model.getValue("ModelBP_FORM.BP_DATE")
      date = date ? date.format("yyyy-MM-dd") : ""
      def hour = model.getValue("ModelBP_FORM.BP_HOUR")
      hour = hour ? (hour.getAt(0..1) + ":" + hour.getAt(2..3)) : ""
      def numOf = model.getValue("ModelBP_FORM.BP_NUMOF")
      numOf = numOf ? numOf : ""
      def info = model.getValue("ModelBP_FORM.BP_RESPONSE")
      info = info ? info : ""
      mail.sendMail([email] as String[], "Potwierdzenie rezerwacji", """\
      <html>
      <body>
        <h1>Potwierdzenie rezerwacji</h1>
        <p>Numer Twojego zgłoszenia: <strong>${processId}</strong></p>
        <p>Data rezerwacji: <strong>${date}</strong></p>
        <p>Godzina rezerwacji: <strong>${hour}</strong></p>
        <p>Liczba miejsc: <strong>${numOf}</strong></p>
        <p>Dodatkowe informacje: <strong>${info}</strong></p>
      </body>
      </html>
      """)  
    }
    return "toCONFIRM_OFFER" 
  }
}

class RejectRequestHandler extends ProcessScriptHandler {
  String run() {
    String email = model.getValue("ModelBP_FORM.BP_EMAIL")
    if (email) {
      def date = model.getValue("ModelBP_FORM.BP_DATE")
      date = date ? date.format("yyyy-MM-dd") : ""
      def hour = model.getValue("ModelBP_FORM.BP_HOUR")
      hour = hour ? (hour.getAt(0..1) + ":" + hour.getAt(2..3)) : ""
      def numOf = model.getValue("ModelBP_FORM.BP_NUMOF")
      numOf = numOf ? numOf : ""
      def info = model.getValue("ModelBP_FORM.BP_RESPONSE")
      info = info ? info : ""
      mail.sendMail([email] as String[], "Rezerwacja", """\
      <html>
      <body>
        <h1>Przepraszamy ale w przekazanym terminie nie możemy zrealizować zamówienia.</h1>
        <p>Numer Twojego zgłoszenia: <strong>${processId}</strong></p>
        <p>Data rezerwacji: <strong>${date}</strong></p>
        <p>Godzina rezerwacji: <strong>${hour}</strong></p>
        <p>Liczba miejsc: <strong>${numOf}</strong></p>
        <p>Dodatkowe informacje: <strong>${info}</strong></p>
      </body>
      </html>
      """)  
    }
    return "toSDEndState" 
  }
}
