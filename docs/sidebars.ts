import type {SidebarsConfig} from '@docusaurus/plugin-content-docs';

const sidebars: SidebarsConfig = {
  docsSidebar: [
    {
      type: 'category',
      label: 'Docs',
      collapsible: false,
      items: [
        'index',
      ],
    },
  ],
};

export default sidebars;
