<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
 <html>
 <body>
 <h2>Planetki</h2>
 <table>
 <xsl:for-each select="SOLAR_SYSTEM/PLANETS/PLANET">
  <tr>
    <td style="color:{@COLOR}"><xsl:value-of select="NAME"/></td>
  </tr>
  </xsl:for-each>
 </table>
 </body>
 </html>
</xsl:template>

</xsl:stylesheet>
