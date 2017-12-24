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
      <xsl:if test="@plec='k'">
      <li style="color:red">
       <u><xsl:value-of select="nazwisko"/></u>
       <b><xsl:value-of select="imie"/></b>
       grupa: <xsl:value-of select="grupa"/>
      </li>
      </xsl:if>
      <xsl:if test="@plec='m'">
      <li style="color:blue">
       <u><xsl:value-of select="nazwisko"/></u>
       <b><xsl:value-of select="imie"/></b>
       grupa: <xsl:value-of select="grupa"/>
      </li>
      </xsl:if>
    </xsl:for-each>
  </ol>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
