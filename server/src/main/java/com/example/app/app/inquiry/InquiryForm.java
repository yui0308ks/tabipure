package com.example.app.app.inquiry;


public class InquiryForm {
    // @NotBlank(message = "お名前を入力してください")
    // @Size(max = 64, message="お名前は64文字以内で入力してください")
    private String name;
  
    // @NotBlank(message = "メールアドレスを入力してください")
    // @Size(max = 128, message = "メールアドレスは128文字以内で入力してください")
    // @Email(message = "メールアドレスを正しく入力してください")
    private String email;
    
    // @NotBlank(message = "お問い合わせ内容を入力してください")
    // @Size(max = 512, message = "お問い合わせ内容は512文字以内で入力してください")
    private String contents;
        
    public InquiryForm(String name, String email, String contents) {
      this.name = name;
      this.email = email;
      this.contents = contents;
    }
    
    public InquiryForm() {
      this("", "", "");
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
    return email;
    }
    public String getContents(){
    return contents;
    }
    public void setName(String name){
    this.name = name;
    }
    public void setEmail(String email){
    this.email = email;
    }
    public void setContents(String contents){
    this.contents = contents;
    }
}