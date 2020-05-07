<%@ Page Language="C#" AutoEventWireup="true" CodeFile="5-6.aspx.cs" Inherits="_5_6" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        Session对象页面间传值<br />
        用户名:<asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="进入聊天室" />
    
    </div>
    </form>
</body>
</html>
