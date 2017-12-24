<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>My CD Collection</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th>Imie</th>
      <th>Nazwisko</th>
      <th>Grupa</th>
    </tr>
    <xsl:for-each select="studenci/student">
    <tr>
      <td><xsl:value-of select="imie"/></td>
      <td><xsl:value-of select="nazwisko"/></td>
      <td><xsl:value-of select="grupa"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
