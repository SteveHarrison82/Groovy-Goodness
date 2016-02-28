def username = "mrhaki"
// String value is enclosed in 
// single quotes.
assert username.inspect() == "'mrhaki'"


def user = "${username}" 
// user is GStringImpl not a String object,
// so no single quotes are added by
// inspect() to show value is a String object.
assert user.inspect() == "mrhaki"


def multiline = '''Hello mrhaki,
how you're doing?'''
// Special characters like tab,
// line feed and single quotes
// are escaped.
assert multiline.inspect() == /'Hello mrhaki,\nhow you\'re doing?'/


def list = [42, '1', ['Groovy rocks!']]
// String values in the list are
// enclosed in single quotes.
assert list.inspect() == "[42, '1', ['Groovy rocks!']]"


def range = 21..<24
// Ranges are shown 
// with .. or ..<.
assert range.inspect() == '21..<24'


def m = [a: 1, b: '1']
// Map keys and values are shown
// as their base type. Mostly
// keys are String values, so with
// inspect() they are enclosed in quotes.
assert m.inspect() == "['a':1, 'b':'1']"


import org.w3c.dom.Document
import org.w3c.dom.Element
import groovy.xml.DOMBuilder

def xmlString = '<sample><username>mrhaki</username></sample>'
Document doc = DOMBuilder.newInstance().parseText(xmlString)
Element root = doc.documentElement.firstChild
// XML Element objects are shown as 
// textual XML.
assert root.inspect().trim() == '<?xml version="1.0" encoding="UTF-8"?><username>mrhaki</username>'
