package variable

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.xml.XmlSlurper
import object.GroovyObj

def list = [new GroovyObj(name: 'A'), new GroovyObj(name: 'B')];

// 转成json的格式
def json = JsonOutput.toJson(list)


println json // [{"name":"A"},{"name":"B"}]

println JsonOutput.prettyPrint(json)
// [
//    {
//        "name": "A"
//    },
//    {
//        "name": "B"
//    }
//]

def jsonSlurper = new JsonSlurper();
def listObjT = jsonSlurper.parseText(json);
// def listObj = jsonSlurper.parse(); // 各自的类型
println listObjT // [[name:A], [name:B]]
