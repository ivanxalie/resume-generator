# Resume Generator

    This project generates a resume based on an incoming message.

## Dependencies
- This project has the following dependencies:
- Spring Boot WebFlux
- Spring Boot DevTools
- Lombok
- Spring Boot Starter Test
- Reactor Test
- iText PDF 5.5.13.3
- iText HTML2PDF 4.0.5
- Jakarta XML Bind API 4.0.0
- Activation 1.1.1
- JAXB Runtime 4.0.2

## Building and Running the Project
    To build and run the project, you will need to have Maven installed. Once Maven is installed, navigate to the project root and run the following command:
    mvn spring-boot:run

## Generating a PDF
    To generate a PDF, make a POST request to the following endpoint: http://localhost:8080/resume. The request body should be a JSON object that represents a resume. The server will respond with a PDF file that represents the generated resume.

## Request example
    {
    "name": "John Doe",
    "position_title": "Java Developer",
    "contact_information": [
        {
            "type": "address",
            "location": "real location"
        },
        {
            "type": "icon",
            "iconSrc": "$icons:linkedin",
            "link": "https://www.linkedin.com/in/example/"
        },
        {
            "type": "icon",
            "iconSrc": "$icons:telegram",
            "link": "https://t.me/example"
        },
        {
            "type": "icon",
            "iconSrc": "$icons:whatsapp",
            "link": "https://wa.me/0000000"
        },
        {
            "type": "icon",
            "iconSrc": "$icons:github",
            "link": "https://github.com/user_name"
        }
    ],
    "professional_summary": "Experienced software engineer with expertise in Java and Spring",
    "work_experience": [
        {
            "job_title": "Software Engineer",
            "company_name": "Acme Corporation",
            "dates_of_employment": "Jan 2018 - Present",
            "job_duties": [
                "Designed and implemented RESTful APIs using Spring Boot",
                "Collaborated with UX team to develop responsive UI using AngularJS"
            ],
            "accomplishments": [
                "Developed a new API that reduced response time by 50%",
                "Implemented a caching layer that reduced database queries by 80%"
            ]
        }
    ],
    "education": [
        {
            "name": "Bachelor of Science",
            "institution": "ACME State University",
            "graduation_date": "June 2017",
            "contact": {
                "type": "icon",
                "iconSrc": "https://upload.wikimedia.org/wikipedia/commons/5/5e/Acme_Markets_lolo.svg",
                "link": "https://en.wikipedia.org/wiki/Acme_Markets"
            }
        }
    ],
    "skills": [
        "Java",
        "Spring",
        "AngularJS",
        "RESTful APIs",
        "Agile software development"
    ],
    "certifications": [
        "Certified Java Developer",
        "Certified Scrum Master"
    ],
    "awards": [
        "Employee of the Month (Acme Corporation, June 2020)"
    ],
    "professional_memberships": [
        "Association for Computing Machinery",
        "Institute of Electrical and Electronics Engineers"
    ]
    }