<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <head>
      <style> ol li u { padding-right: 5px; } </style>
    </head>
  <h2>Studenci</h2>
    <ol>
    <xsl:for-each select="studenci/student">
      <xsl:choose>
      <xsl:when test="@plec='k'">
      <li style="color:red">
       <u><xsl:value-of select="nazwisko"/></u>
       <b><xsl:value-of select="imie"/></b>
       grupa: <xsl:value-of select="grupa"/>
     </li>
     </xsl:when>
     <xsl:otherwise>
       <li style="color:blue">
        <u><xsl:value-of select="nazwisko"/></u>
        <b><xsl:value-of select="imie"/></b>
        grupa: <xsl:value-of select="grupa"/>
        </li>
     </xsl:otherwise>
     </xsl:choose>
    </xsl:for-each>
  </ol>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
