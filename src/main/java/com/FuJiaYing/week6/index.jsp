<%@include file="header.jsp" %>
   <h2>Welcome to my online shop home page.</h2><br>
   <form method="get" target="_blank"  action="search">
      <!--<url-pattern>/search</url-pattern> -->
      <input type="text"name="txt" size="30"/>
      <select name="search">
         <option value="baidu">Baidu</option>
         <option value="bing">bing</option>
         <option value="google">google</option>
      </select>
      <input type="sumbit" value="search"/>
      </form>
<%@include file="footer.jsp" %>