<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <xsl:param name="css"/>

    <xsl:template match="/">
        <html>
            <head>
                <style type="text/css">
                    <xsl:value-of select="$css"/>
                </style>
            </head>
            <body>
                <h1 class="name center">
                    <xsl:value-of select="resume/name"/>
                </h1>
                <h2 class="position-title center">
                    <xsl:value-of select="resume/positionTitle"/>
                </h2>
                <xsl:variable name="contact_info" select="resume/contactInformation"/>
                <xsl:if test="$contact_info">
                    <div class="contacts">
                        <div>
                            <xsl:apply-templates select="$contact_info/contact"/>
                        </div>
                    </div>
                </xsl:if>
                <xsl:variable name="summary" select="resume/professionalSummary"/>
                <xsl:if test="$summary">
                    <div class="professional-summary">
                        <h2 class="center">SUMMARY</h2>
                        <div class="summary">
                            <p>
                                <xsl:value-of select="$summary"/>
                            </p>
                        </div>
                    </div>
                </xsl:if>
                <xsl:variable name="skills" select="resume/skills"/>
                <xsl:if test="$skills">
                    <div class="skills">
                        <h2 class="center">SKILLS</h2>
                        <ul>
                            <xsl:for-each select="$skills/skill">
                                <li>
                                    <xsl:value-of select="."/>
                                </li>
                            </xsl:for-each>
                        </ul>
                    </div>
                </xsl:if>
                <xsl:variable name="workExperience" select="resume/workExperience"/>
                <xsl:if test="$workExperience">
                    <div class="work-experience">
                        <h2 class="center">EXPERIENCE</h2>
                        <xsl:for-each select="$workExperience/job">
                            <xsl:apply-templates select="."/>
                        </xsl:for-each>
                    </div>
                </xsl:if>
                <xsl:variable name="education" select="resume/education"/>
                <xsl:if test="$education">
                    <div class="education">
                        <h2 class="center">EDUCATION</h2>
                        <xsl:for-each select="$education/degree">
                            <xsl:apply-templates select="."/>
                        </xsl:for-each>
                    </div>
                </xsl:if>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="contact">
        <xsl:choose>
            <xsl:when test="@xsi:type = 'address'">
                <h3>
                    <xsl:value-of select="location"/>
                </h3>
            </xsl:when>
            <xsl:when test="@xsi:type = 'icon'">
                <a>
                    <xsl:attribute name="href">
                        <xsl:value-of select="link"/>
                    </xsl:attribute>
                    <xsl:attribute name="target">
                        _blank
                    </xsl:attribute>
                    <img class="icon">
                        <xsl:attribute name="src">
                            <xsl:value-of select="iconSrc"/>
                        </xsl:attribute>
                        <xsl:attribute name="alt">
                            <xsl:value-of select="link"/>
                        </xsl:attribute>
                    </img>
                </a>
            </xsl:when>
        </xsl:choose>
    </xsl:template>

    <xsl:template match="job">
        <div class="job">
            <div class="company">
                <h2>
                    <xsl:apply-templates select="./contact"/>
                </h2>
                <h2>
                    <xsl:value-of select="./datesOfEmployment"/>
                </h2>
            </div>
            <xsl:variable name="accomplishments" select="./accomplishments"/>
            <xsl:variable name="duties" select="./jobDuties"/>
            <xsl:if test="$accomplishments | $duties">
                <div class="accomplishments-duties">
                    <xsl:if test="$accomplishments">
                        <div class="accomplishments">
                            <h3>ACCOMPLISHMENTS</h3>
                            <ul>
                                <xsl:for-each select="$accomplishments/accomplishment">
                                    <li>
                                        <xsl:value-of select="."/>
                                    </li>
                                </xsl:for-each>
                            </ul>
                        </div>
                    </xsl:if>
                    <xsl:if test="$duties">
                        <div class="duties">
                            <h3>RESPONSIBILITIES</h3>
                            <ul>
                                <xsl:for-each select="$duties/duty">
                                    <li>
                                        <xsl:value-of select="."/>
                                    </li>
                                </xsl:for-each>
                            </ul>
                        </div>
                    </xsl:if>
                </div>
            </xsl:if>
        </div>
    </xsl:template>

    <xsl:template match="degree">
        <div class="university-name">
            <div>
                <h3>
                    <xsl:value-of select="institution"/>
                </h3>
            </div>
            <div>
                <xsl:apply-templates select="contact"/>
            </div>
            <div>
                <h2>
                    <xsl:value-of select="graduationDate"/>
                </h2>
                <h3>
                    <xsl:value-of select="name"/>
                </h3>
            </div>
        </div>
    </xsl:template>

</xsl:stylesheet>