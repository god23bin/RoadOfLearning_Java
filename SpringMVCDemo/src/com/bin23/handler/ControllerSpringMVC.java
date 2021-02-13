package com.bin23.handler;

import com.bin23.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SessionAttributes(value = {"stu1","stu2"})//可以把Model中的数据stu1，stu2，同时存放到Session中
@Controller
public class ControllerSpringMVC {

    @RequestMapping("toSuccess")
    public String helloSpringMVC(){
        return "success";
    }

    @RequestMapping(value = "toSuccess2",method = RequestMethod.POST)
    public String aboutMethod(){
        return "success";
    }

    @RequestMapping(value = "toSuccess3",method = RequestMethod.POST,params = {"name = a","age = 23"})
    public String aboutParams(){
        return "success";
    }

    @RequestMapping("A/**/a")
    public String aboutRoute(){
        return "success";
    }

    @RequestMapping("A/a?c/route")
    public String aboutQ(){
        return "success";
    }

    @RequestMapping("toSuccess/{name}")
    public String testPathVariable(@PathVariable("name") String name){
        System.out.println(name);
        return "success";
    }

    @RequestMapping(value = "testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id){
        System.out.println("删除" + id);
        //模拟删除业务...
        return "success";
    }

    @RequestMapping(value = "testRest/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("修改" + id);
        //模拟修改业务...
        return "success";
    }

    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam("username") String username){
        System.out.println(username);
        return "success";
    }

    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String al) {
        System.out.println(al);
        return "success";
    }

    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String jSessionId){
        System.out.println(jSessionId);
        return "success";
    }

    @RequestMapping("testReceiveEntity")
    public String testReceiveEntity(Student student){
        System.out.println(student.toString());
        return "success";
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {//ModelAndView:既有数据，又有视图
        //ModelAndView:Model - M     View - V
        ModelAndView mv = new ModelAndView("success");//view:  /views/success.jsp
        Student stu1 = new Student("LeBron",23) ;
        mv.addObject("student1", stu1);//相当于request.setAttribute("student1", stu1);
        return mv;
    }

    @RequestMapping("testModelMap")
    public String testModelMap(ModelMap mm) {//success
        Student stu2 = new Student("Kobe",24) ;
        mm.put("student2", stu2);//request域
        return "success";  //view
    }

    @RequestMapping("testMap")
    public String testMap(Map<String,Object> m) {
        Student stu3 = new Student("Lin",17) ;
        m.put("student3", stu3);//request域
        return "success";
    }

    @RequestMapping("testModel")
    public String testModel(Model model) {
        Student stu4 = new Student("Wade",3) ;
        model.addAttribute("student4",stu4);//request域
        return "success";
    }

    //在任何一次请求前，都会先执行@ModelAttribute修饰的方法
    //如果不加这个注解，那么下面方法不会知道学生信息，就只会改下名字
    //加上该注解，就会先执行，即查出学生信息
    @ModelAttribute
    public void queryStudentById(Map<String,Object> map) {
        //模拟调用三层查询数据库的操作
        //StuentService stuService = new StudentServiceImpl();
        //Student student = stuService.queryStudentById(31);
        //假装查出来了stu5
        Student stu5 = new Student("Three",23) ;
        map.put("stu", stu5) ;//约定：map的key 就是方法参数 类型的首字母小写
    }

    //修改，把Three改成前端输入的名字
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(@ModelAttribute("stu") Student student) {
        student.setName(student.getName());//将名字修改为前端输入的名字
        System.out.println(student.getName()+","+student.getAge());
        return "success";
    }

    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect() {
//        return "forward:/views/success.jsp";
        return "redirect:/views/success.jsp";
    }

    @RequestMapping("testConverter")
    public String testConverter(@RequestParam("studentInfo")  Student student) {// 前端：LeBron-23
        System.out.println(student.getName()+","+student.getAge());
        return "success";
    }

    @ResponseBody//作用是将java对象转为json格式的数据。
    @RequestMapping("testAjax")
    public List<Student> testAjax() {
        //模拟业务，查询出学生集合
        Student s1 = new Student("God23Bin",18);
        Student s2 = new Student("Justin",18);
        Student s3 = new Student("Lay",20);
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        return students;
    }


    @RequestMapping(value="testUpload") //abc.png
    public String testUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("文件描述信息："+desc);
        //jsp中上传的文件：file
        InputStream in = file.getInputStream();//IO
        String fileName = file.getOriginalFilename();
        OutputStream out = new FileOutputStream("F:\\About_Test\\SpringMVCUpload\\"+fileName);

        byte[] buf = new byte[1024];
        int len = -1;
        while(( len = in.read(buf)) !=-1) {
            out.write(buf, 0, len);
        }
        out.close();
        in.close();
        //将file上传到服务器中的 某一个硬盘文件中
        System.out.println("上传成功！");
        return "success";
    }

    @RequestMapping("testInterceptor")
    public String testInterceptor() {
        System.out.println("处理请求中");
        return "success";
    }

}
