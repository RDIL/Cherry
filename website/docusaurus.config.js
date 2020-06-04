module.exports = {
  title: "Cherry Client",
  tagline: "The Cherry Minecraft 1.14.4 client!",
  url: "https://cherry.rdil.rocks",
  baseUrl: "/",
  favicon: "",
  organizationName: "RDIL",
  projectName: "Cherry",
  themeConfig: {
    navbar: {
      title: "Cherry Client",
      links: [
        {
          to: "docs/install",
          activeBasePath: "docs",
          label: "Install",
          position: "left",
        },
        {
          to: "blog",
          label: "Blog",
          position: "left",
        },
        {
          href: "https://github.com/RDIL/Cherry",
          label: "GitHub",
          position: "right",
        },
      ],
    },
    footer: {
      style: "dark",
      links: [
        {
          title: "Docs",
          items: [
            {
              label: "Install",
              to: "docs/install/",
            },
          ],
        },
        {
          title: "More",
          items: [
            {
              label: "Blog",
              to: "blog",
            },
            {
              label: "GitHub",
              href: "https://github.com/RDIL/Cherry",
            },
          ],
        },
      ],
      copyright: `Copyright © ${new Date().getFullYear()} Reece Dunham.`,
    },
  },
  presets: [
    [
      "@docusaurus/preset-classic",
      {
        docs: {
          homePageId: "doc1",
          sidebarPath: require.resolve("./sidebars.js"),
          editUrl: "https://github.com/RDIL/Cherry/edit/master/website/",
        },
        blog: {
          showReadingTime: true,
          editUrl: "https://github.com/RDIL/Cherry/edit/master/website/blog/",
        },
        theme: {
          customCss: require.resolve("./src/css/custom.css"),
        },
      },
    ],
  ],
}
