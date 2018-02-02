# Struts2FileUpload

## Runtime Environment
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk6downloads-1902814.html)
- [Struts Framework 2.3.15](http://struts.apache.org)
- [Tomcat 7](http://tomcat.apache.org/)

## Struts 2 File Upload
### Struts 2 File Upload Configuration
- `web.xml`
- `UploadFile.jsp`
- `struts.xml`
- `UploadFileAction.java`
- `FileUtil.java`
- `UploadFileSuccess.jsp`

![Struts2-File-Upload-Request](http://www.wailian.work/images/2018/02/02/Struts2-File-Upload-Request-450x172.png)
![Struts2-File-Upload-Response](http://www.wailian.work/images/2018/02/02/Struts2-File-Upload-Response-450x66.png)

## Struts 2 Multiple File Upload
- `UploadMultipleFile.jsp`
- `UploadMultipleFileAction.java`
- `UploadMultipleFileSuccess.jsp`
- `struts.xml`

```
<action name="uploadMultiple">
	<result>/UploadMultipleFile.jsp</result>
</action>

<action name="UploadMultipleFile" class="com.journaldev.struts2.actions.UploadMultipleFileAction">
	<param name="filesPath">myfiles</param>
	<result name="success">/UploadMultipleFileSuccess.jsp</result>
	<result name="input">/UploadMultipleFile.jsp</result>
	<interceptor-ref name="defaultStack">
		<param name="fileUpload.maximumSize">10485760</param>
		<param name="fileUpload.allowedTypes">text/plain,image/jpeg</param>
	</interceptor-ref>
</action>
```

![Struts2-Multiple-File-Upload-Request](http://www.wailian.work/images/2018/02/02/Struts2-Multiple-File-Upload-Request-450x221.png)
![Struts2-Multiple-File-Upload-Response](http://www.wailian.work/images/2018/02/02/Struts2-Multiple-File-Upload-Response-450x106.png)

## Links
- [Struts 2 File Upload Example](https://www.journaldev.com/2192/struts-2-file-upload-example)
